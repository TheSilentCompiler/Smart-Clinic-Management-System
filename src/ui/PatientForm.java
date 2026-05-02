package ui;

import dao.PatientDAO;
import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PatientForm extends JFrame {

    JLabel nameLabel, ageLabel, genderLabel, phoneLabel;
    JTextField nameField, ageField, phoneField;
    JComboBox<String> genderBox;
    JButton addButton;

    public PatientForm() {

        // Professional background color consistent with dashboard
        getContentPane().setBackground(new Color(245, 249, 255));
        setTitle("Patient Form");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 13);
        Color primaryBlue = new Color(0, 102, 204);

        // Labels
        nameLabel = new JLabel("Full Name:");
        ageLabel = new JLabel("Age:");
        genderLabel = new JLabel("Gender:");
        phoneLabel = new JLabel("Phone Number:");

        // Input Fields
        nameField = new JTextField();
        ageField = new JTextField();
        phoneField = new JTextField();
        genderBox = new JComboBox<>(new String[]{"Male", "Female"});

        addButton = new JButton("Add Patient");

        // Layout Positions
        nameLabel.setBounds(50, 40, 120, 25);
        nameLabel.setFont(labelFont);
        nameField.setBounds(180, 40, 200, 30);
        nameField.setFont(inputFont);

        ageLabel.setBounds(50, 90, 120, 25);
        ageLabel.setFont(labelFont);
        ageField.setBounds(180, 90, 200, 30);
        ageField.setFont(inputFont);

        genderLabel.setBounds(50, 140, 120, 25);
        genderLabel.setFont(labelFont);
        genderBox.setBounds(180, 140, 200, 30);
        genderBox.setFont(inputFont);
        genderBox.setBackground(Color.WHITE);

        phoneLabel.setBounds(50, 190, 120, 25);
        phoneLabel.setFont(labelFont);
        phoneField.setBounds(180, 190, 200, 30);
        phoneField.setFont(inputFont);

        // Button Styling & Hover Effect
        addButton.setBounds(150, 270, 150, 35);
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        addButton.setBackground(Color.WHITE);
        addButton.setForeground(primaryBlue);
        addButton.setFocusPainted(false);
        addButton.setBorder(BorderFactory.createLineBorder(primaryBlue, 1));

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

        // Add to frame
        add(nameLabel);
        add(ageLabel);
        add(genderLabel);
        add(phoneLabel);
        add(nameField);
        add(ageField);
        add(genderBox);
        add(phoneField);
        add(addButton);

        // Action
        addButton.addActionListener((ActionEvent e) -> {
            try {
                Patient p = new Patient(
                        0,
                        nameField.getText(),
                        Integer.parseInt(ageField.getText()),
                        genderBox.getSelectedItem().toString(),
                        phoneField.getText()
                );

                new PatientDAO().addPatient(p);

                JOptionPane.showMessageDialog(this, "Patient Added Successfully!");

                nameField.setText("");
                ageField.setText("");
                phoneField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for age.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}