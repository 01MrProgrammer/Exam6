import java.sql.*;
class JDBC 
{
    public static void main(String args[])
    {
        try{
            Class.forName("com.mysql.jdbc.drivar");
            String url="jdbc:mysql://localhost:3306/data";
            String username="root";
            String password="root";
            Connection con=DriverManager.getConnection(url,username,password);
            if(con.isClosed())
            {
                System.out.println("Connection is Closed");
            }else{
                System.out.println("Connection Created...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}