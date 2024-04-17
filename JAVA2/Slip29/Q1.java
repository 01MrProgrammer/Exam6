import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Q1 {
    // JDBC URL, username, and password of PostgreSQL server
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/your_database";
    static final String USERNAME = "your_username";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Create a statement
            Statement statement = connection.createStatement();

            // Execute query to get the result set
            ResultSet resultSet = statement.executeQuery("SELECT * FROM DONAR");

            // Get metadata
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Get the number of columns
            int columnCount = metaData.getColumnCount();
            System.out.println("Number of columns: " + columnCount);

            // Display column information
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Data Type: " + metaData.getColumnTypeName(i));
                System.out.println("Is Nullable: " + metaData.isNullable(i));
                System.out.println("Is Auto Increment: " + metaData.isAutoIncrement(i));
                System.out.println("Is Read Only: " + metaData.isReadOnly(i));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
