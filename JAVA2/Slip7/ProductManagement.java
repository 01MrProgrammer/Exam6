import java.sql.*;

public class ProductManagement {
    // JDBC URL, username, and password for PostgreSQL
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Step 1: Create Product table
            createProductTable(conn);

            // Step 2: Insert records into Product table
            insertRecords(conn);

            // Step 3: Display all records from Product table
            displayRecords(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Step 1: Create Product table
    private static void createProductTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Product (" +
                "Pid SERIAL PRIMARY KEY," +
                "Pname VARCHAR(255) NOT NULL," +
                "Price DECIMAL(10, 2) NOT NULL" +
                ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Product table created successfully.");
        }
    }

    // Step 2: Insert records into Product table
    private static void insertRecords(Connection conn) throws SQLException {
        String[] products = {
                "('Product 1', 10.50)",
                "('Product 2', 20.75)",
                "('Product 3', 15.00)",
                "('Product 4', 30.25)",
                "('Product 5', 25.50)"
        };
        String sql = "INSERT INTO Product (Pname, Price) VALUES ";
        try (Statement stmt = conn.createStatement()) {
            for (String product : products) {
                stmt.addBatch(sql + product);
            }
            stmt.executeBatch();
            System.out.println("Records inserted into Product table successfully.");
        }
    }

    // Step 3: Display all records from Product table
    private static void displayRecords(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Product";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nProduct Table:");
            System.out.println("Pid\tPname\tPrice");
            while (rs.next()) {
                int pid = rs.getInt("Pid");
                String pname = rs.getString("Pname");
                double price = rs.getDouble("Price");
                System.out.println(pid + "\t" + pname + "\t" + price);
            }
        }
    }
}
