//Q2
//Write a Java program to accept the details of Teacher (TNo, TName, Subject). Insert at
//least 5 Records into Teacher Table and display the details of Teacher who is teaching
//“JAVA” Subject. (Use PreparedStatement Interface) 

// package com.slip16;

import java.sql.*;
import java.util.*;

public class TeacherManagement {
   
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
        Connection conn = null;
        PreparedStatement stmt = null;
        int n, Tno;
        String Tname, Subject;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_database","root","");

            System.out.println("Enter how many records you want to insert: ");
			n=sc.nextInt();
			
			for(int i=0; i<n; i++)
			{
				System.out.println("Enter Teacher No: ");
				Tno=sc.nextInt();
				System.out.println("Enter Teacher Name: ");
				sc.nextLine();			
				Tname=sc.nextLine();
				System.out.println("Enter Subject: ");
				Subject=sc.nextLine();
				PreparedStatement st=conn.prepareStatement("insert into teacher1 values(?,?,?)");
				st.setInt(1, Tno);
				st.setString(2, Tname);
				st.setString(3, Subject);
				st.executeUpdate();
			}
			
			System.out.println("Record inserted Succesfully...");

            // Add more records if needed

            // Displaying details of teachers teaching "JAVA" subject
            String selectQuery = "SELECT * FROM teacher1 WHERE Subject = ?";
            stmt = conn.prepareStatement(selectQuery);
            stmt.setString(1, "JAVA");
            ResultSet rs = stmt.executeQuery();
            System.out.println("\nTeachers teaching JAVA subject:");
            while (rs.next()) {
                System.out.println("Teacher Number: " + rs.getInt("TNo"));
                System.out.println("Teacher Name: " + rs.getString("TName"));
                System.out.println("Subject: " + rs.getString("Subject"));
                System.out.println();
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
