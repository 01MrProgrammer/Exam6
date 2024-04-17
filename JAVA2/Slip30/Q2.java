import java.sql.*;

public class Q2 {
    // JDBC URL, username, and password for PostgreSQL
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Create a statement with ResultSet.TYPE_SCROLL_SENSITIVE to make ResultSet scrollable
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Execute query to retrieve data from the Teacher table
            ResultSet rs = stmt.executeQuery("SELECT * FROM Teacher");

            // Move to the last row of the ResultSet
            rs.last();

            // Get the row count
            int rowCount = rs.getRow();

            // Move back to the first row
            rs.beforeFirst();

            // Print column names
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Iterate through the ResultSet and print data
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

            // Print total number of rows
            System.out.println("Total rows: " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
