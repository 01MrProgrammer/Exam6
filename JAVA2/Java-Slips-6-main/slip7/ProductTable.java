//Q2
//Write a java program for the following:
//i. To create a Product(P_id, P_name, Price) table.
//ii. Insert at least five records into the table.
//iii. Display all the records from a table. 

// package com.slip7;

import java.sql.*;
import java.util.*;
public class ProductTable {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int Pid, n;
		String Pname;
		int Price;
		
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_database","root","");
			
			System.out.println("Enter how many records you want to insert: ");
			n=sc.nextInt();
			
			for(int i=0; i<n; i++)
			{
				System.out.println("Enter Product id: ");
				Pid=sc.nextInt();
				System.out.println("Enter Product Name: ");
				sc.nextLine();			
				Pname=sc.nextLine();
				System.out.println("Enter Product Price: ");
				Price=sc.nextInt();
				PreparedStatement st=con.prepareStatement("insert into Product values(?,?,?)");
				st.setInt(1, Pid);
				st.setString(2, Pname);
				st.setFloat(3, Price);
				st.executeUpdate();
			}
			
			
			
			
			
			System.out.println(n+ " Products Inserted Successfully");
			
		
			PreparedStatement statement=con.prepareStatement("SELECT * FROM Product");
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\nProduct Table:");
            System.out.println("Pid\tPname\tPrice");
            while (resultSet.next()) {
                int pid = resultSet.getInt("Pid");
                String pname = resultSet.getString("Pname");
                double price = resultSet.getDouble("Price");
                System.out.println(pid + "\t" + pname + "\t" + price);
            }
			
		}	
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
