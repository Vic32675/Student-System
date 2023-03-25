import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login extends JFrame {
    private JPanel loginPanel;
    private JLabel regNoLabel;
    private JTextField regNoField;
    private JLabel passwrdLabel;
    private JTextField passwrdField;
    private JButton loginButton;
    private JLabel registerLabel;
    private JButton registerButton;

    public Login(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //login panel

        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        //Add regfiels and label

        regNoLabel = new JLabel("Registration number");
        loginPanel.add(regNoLabel);
        regNoField = new JTextField(20);
        loginPanel.add(regNoField);


        //Add passwrd fields and labels

        passwrdLabel = new JLabel("Password:");
        loginPanel.add(passwrdLabel);
        passwrdField = new JTextField(20);
        loginPanel.add(passwrdField);

        //login
        //button
        loginButton = new JButton("Login");
        loginPanel.add(loginButton);
        loginButton.addActionListener(e -> {
            Homepage homepagewindow = new Homepage();
            homepagewindow.setVisible(true);
        });

        //register option
        registerLabel = new JLabel("Don't have an account?");
        loginPanel.add((registerLabel));
        registerButton = new JButton("Register");
        loginPanel.add(registerButton);
        registerButton.addActionListener(e -> {
            Register registerwindow = new Register();
            registerwindow.setVisible(true);

        });


         add(loginPanel);
         pack();
         setVisible(true);

    }

    public static void main(String[] args) {
        Login login = new Login();
    }
}
