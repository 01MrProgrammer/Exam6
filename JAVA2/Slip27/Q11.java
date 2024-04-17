import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Q11 extends JFrame {
    private DefaultTableModel model;
    private JTable table;

    public Q11() {
        // Set the title of the frame
        super("College Details");

        // Initialize table model with column names
        String[] columnNames = {"CID", "CName", "Address", "Year"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        // Create button to add new college
        JButton addButton = new JButton("Add College");
        addButton.addActionListener(e -> addCollege());

        // Add button to JFrame
        getContentPane().add(addButton, "South");

        // Set frame properties
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void addCollege() {
        // Get college details from user
        String cid = JOptionPane.showInputDialog("Enter CID:");
        String cname = JOptionPane.showInputDialog("Enter College Name:");
        String address = JOptionPane.showInputDialog("Enter Address:");
        String year = JOptionPane.showInputDialog("Enter Year:");

        // Add college details to table model
        model.addRow(new Object[]{cid, cname, address, year});
    }

    public static void main(String[] args) {
        // Create an instance of Q1 frame
        SwingUtilities.invokeLater(Q1::new);
    }
}
