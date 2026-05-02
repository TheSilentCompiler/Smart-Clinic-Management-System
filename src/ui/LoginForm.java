package ui;

import dao.UserDAO;
import model.User;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginForm() {

        getContentPane().setBackground(new Color(234, 246, 255));
        setTitle("Login");
        setSize(750,300);
        setLocation(320, 210);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exist the entire program when closing the window

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 100, 25);
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 100, 25);
        passLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        usernameField.setBounds(130, 30, 150, 25);
        passwordField.setBounds(130, 70, 150, 25);

        loginButton.setBounds(100, 120, 120, 30);
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        //loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.WHITE);
        getRootPane().setDefaultButton(loginButton);//We can login by pressing enter

        //image on login page
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/logo3.png"));
        //for scaling the image
        Image i1 = imageIcon.getImage().getScaledInstance(450,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1); //passing that image referencce
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320, 10, 400, 260);
        add(label);


        add(userLabel);
        add(passLabel);
        add(usernameField);
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener((ActionEvent e) -> {

            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            UserDAO dao = new UserDAO();
            User user = dao.login(username, password);

            if (user != null) { //checks weather its present in Database
                JOptionPane.showMessageDialog(this, "Login Successful!");

                if(user.getRole().getRoleName().equalsIgnoreCase("admin")){ // open main system
                    new AdminDashboard();
                }
                 else {
                     new ReceptionistDashboard();
                }
                this.dispose();   // close login window

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!");
            }
        });

        setVisible(true);
    }
}