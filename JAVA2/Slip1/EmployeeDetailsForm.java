import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDetailsForm extends JFrame implements ActionListener {
    JLabel enoLabel, enameLabel, designationLabel, salaryLabel;
    JTextField enoField, enameField, designationField, salaryField;
    JButton submitButton;

    public EmployeeDetailsForm() {
        setTitle("Employee Details Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        enoLabel = new JLabel("Employee Number:");
        enoField = new JTextField(10);
        enameLabel = new JLabel("Employee Name:");
        enameField = new JTextField(10);
        designationLabel = new JLabel("Designation:");
        designationField = new JTextField(10);
        salaryLabel = new JLabel("Salary:");
        salaryField = new JTextField(10);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(enoLabel);
        panel.add(enoField);
        panel.add(enameLabel);
        panel.add(enameField);
        panel.add(designationLabel);
        panel.add(designationField);
        panel.add(salaryLabel);
        panel.add(salaryField);
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeDetailsForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            saveEmployeeDetails();
        }
    }

    private void saveEmployeeDetails() {
        String eno = enoField.getText();
        String ename = enameField.getText();
        String designation = designationField.getText();
        String salary = salaryField.getText();

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/your_database", "username", "password");
            String query = "INSERT INTO employees (eno, ename, designation, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, eno);
            preparedStatement.setString(2, ename);
            preparedStatement.setString(3, designation);
            preparedStatement.setString(4, salary);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee details saved successfully!");
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving employee details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

