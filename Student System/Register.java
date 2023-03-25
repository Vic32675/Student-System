import javax.swing.*;
import java.sql.*;
import java.awt.*;


public class Register extends JFrame {
    private JPanel registerPanel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel regNoLabel;
    private JTextField regNoField;

    private JLabel phoneNoLabel;
    private JTextField phoneNoField;
    private JLabel passwrdLabel;
    private JTextField passwrdField;
    private JButton registerButton;

    public Register(){
        setTitle("Register");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS));

        nameLabel = new JLabel("Enter Name");
        registerPanel.add(nameLabel);
        nameField = new JTextField(20);
        registerPanel.add(nameField);

        regNoLabel = new JLabel("Enter Registration No:");
        registerPanel.add(regNoLabel);
        regNoField = new JTextField(20);
        registerPanel.add(regNoField);

        phoneNoLabel = new JLabel("Phone Number:");
        registerPanel.add(phoneNoLabel);
        phoneNoField = new JTextField(10);
        registerPanel.add(phoneNoField);

        passwrdLabel = new JLabel("Password");
        registerPanel.add(passwrdLabel);
        passwrdField = new JTextField(20);
        registerPanel.add(passwrdField);

        registerButton = new JButton("Register");
        registerPanel.add(registerButton);

        add(registerPanel);
        pack();
        setVisible(true);



    }

}
