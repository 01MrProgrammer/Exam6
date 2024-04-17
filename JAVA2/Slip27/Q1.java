import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Q1 extends JFrame {
    // Sample data for the table
    private Object[][] data = {
            {"CID001", "ABC College", "123 Main St", "2022"},
            {"CID002", "XYZ College", "456 Elm St", "2023"},
            // Add more data as needed
    };

    // Column names for the table
    private String[] columnNames = {"CID", "CName", "Address", "Year"};

    public Q1() {
        // Set the title of the frame
        super("College Details");

        // Create a DefaultTableModel with data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a JTable with the DefaultTableModel
        JTable table = new JTable(model);

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Set frame properties
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Q1 frame
        SwingUtilities.invokeLater(Q1::new);
    }
}
