import java.sql.*;

public class Q1 {
    // JDBC URL, username, and password for PostgreSQL
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute query to retrieve metadata
            ResultSet rs = stmt.executeQuery("SELECT * FROM DONAR");

            // Get ResultSetMetaData
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Display column details
            System.out.println("Column Information for DONAR Table:");
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnType = metaData.getColumnTypeName(i);
                int columnSize = metaData.getColumnDisplaySize(i);
                System.out.println("Column Name: " + columnName);
                System.out.println("Column Type: " + columnType);
                System.out.println("Column Size: " + columnSize);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
