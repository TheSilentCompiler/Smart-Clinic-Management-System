package ui;

import dao.DoctorDAO;
import model.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorForm extends JFrame {

    JLabel nameLabel, specLabel;
    JTextField nameField, specField;
    JButton addButton;

    public DoctorForm() {

        // Professional background color
        getContentPane().setBackground(new Color(245, 249, 255));
        setTitle("Doctor Form");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 13);
        Color primaryBlue = new Color(0, 102, 204);

        nameLabel = new JLabel("Doctor Name:");
        specLabel = new JLabel("Specialization:");

        nameField = new JTextField();
        specField = new JTextField();

        // Consistent Button Styling
        addButton = new JButton("Add Doctor");

        // Layout Adjustments
        nameLabel.setBounds(50, 50, 120, 25);
        nameLabel.setFont(labelFont);

        specLabel.setBounds(50, 100, 120, 25);
        specLabel.setFont(labelFont);

        nameField.setBounds(180, 50, 200, 30);
        nameField.setFont(inputFont);
        nameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        specField.setBounds(180, 100, 200, 30);
        specField.setFont(inputFont);
        specField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        addButton.setBounds(150, 170, 150, 35);
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        addButton.setBackground(Color.WHITE);
        addButton.setForeground(primaryBlue);
        addButton.setFocusPainted(false);
        addButton.setBorder(BorderFactory.createLineBorder(primaryBlue, 1));

        // Hover Effect logic
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addButton.setBackground(primaryBlue);
                addButton.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                addButton.setBackground(Color.WHITE);
                addButton.setForeground(primaryBlue);
            }
        });

        add(nameLabel);
        add(specLabel);
        add(nameField);
        add(specField);
        add(addButton);

        addButton.addActionListener((ActionEvent e) -> {

            Doctor d = new Doctor(
                    0,
                    nameField.getText(),
                    specField.getText()
            );

            new DoctorDAO().addDoctor(d);

            JOptionPane.showMessageDialog(this, "Doctor Added Successfully!");

            nameField.setText("");
            specField.setText("");
        });

        setVisible(true);
    }
}