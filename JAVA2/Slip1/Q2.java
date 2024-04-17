import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Q2 extends JFrame implements ActionListener {
    JTextField txtEno, txtEName, txtDesignation, txtSalary;
    JButton btnSave;
    
    public Q2() {
        setTitle("Employee Details");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(5, 2));
        
        panel.add(new JLabel("Employee Number:"));
        txtEno = new JTextField();
        panel.add(txtEno);
        
        panel.add(new JLabel("Employee Name:"));
        txtEName = new JTextField();
        panel.add(txtEName);
        
        panel.add(new JLabel("Designation:"));
        txtDesignation = new JTextField();
        panel.add(txtDesignation);
        
        panel.add(new JLabel("Salary:"));
        txtSalary = new JTextField();
        panel.add(txtSalary);
        
        btnSave = new JButton("Save");
        btnSave.addActionListener(this);
        panel.add(btnSave);
        
        add(panel);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            saveEmployeeDetails();
        }
    }
    
    public void saveEmployeeDetails() {
        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");
            
            // Connect to the database
            String url = "jdbc:postgresql://localhost:5432/your_database_name";
            String username = "your_username";
            String password = "your_password";
            Connection con = DriverManager.getConnection(url, username, password);
            
            // Prepare SQL statement
            String sql = "INSERT INTO employee (Eno, EName, Designation, Salary) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(txtEno.getText()));
            pstmt.setString(2, txtEName.getText());
            pstmt.setString(3, txtDesignation.getText());
            pstmt.setDouble(4, Double.parseDouble(txtSalary.getText()));
            
            // Execute the statement
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Employee details saved successfully.");
            
            // Close resources
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Q2().setVisible(true);
        });
    }
}
