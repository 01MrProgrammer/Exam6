import java.sql.*;

class JDBC {
    public static void main(String args[]) {
        try {
            // Load PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish connection to the PostgreSQL database
            String url = "jdbc:postgresql://localhost:5432/data"; // Modify URL as needed
            String username = "your_username"; // Modify username as needed
            String password = "your_password"; // Modify password as needed
            Connection con = DriverManager.getConnection(url, username, password);

            if (con.isClosed()) {
                System.out.println("Connection is Closed");
            } else {
                System.out.println("Connection Created...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
