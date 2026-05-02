package ui;

import dao.AppointmentDAO;
import dao.PatientDAO;
import dao.DoctorDAO;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;

public class AppointmentForm extends JFrame {

    JComboBox<Patient> patientBox;
    JComboBox<Doctor> doctorBox;
    JTextField dateField;
    JButton addButton;
    JLabel patientLabel, doctorLabel, dateLabel;

    public AppointmentForm() {
        // Professional background color
        getContentPane().setBackground(new Color(245, 249, 255));
        setTitle("Appointment Form");
        setSize(650, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 13);
        Color primaryBlue = new Color(0, 102, 204);

        // Labels
        patientLabel = new JLabel("Select Patient:");
        patientLabel.setBounds(100, 30, 150, 25);
        patientLabel.setFont(labelFont);
        add(patientLabel);

        doctorLabel = new JLabel("Select Doctor:");
        doctorLabel.setBounds(100, 75, 150, 25);
        doctorLabel.setFont(labelFont);
        add(doctorLabel);

        dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setBounds(100, 120, 150, 25);
        dateLabel.setFont(labelFont);
        add(dateLabel);

        // Input Fields
        patientBox = new JComboBox<>();
        patientBox.setBounds(270, 30, 250, 30);
        patientBox.setFont(inputFont);
        patientBox.setBackground(Color.WHITE);

        doctorBox = new JComboBox<>();
        doctorBox.setBounds(270, 75, 250, 30);
        doctorBox.setFont(inputFont);
        doctorBox.setBackground(Color.WHITE);

        dateField = new JTextField("YYYY-MM-DD");
        dateField.setBounds(270, 120, 250, 30);
        dateField.setFont(inputFont);
        dateField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        // Add Button with Professional Style & Hover
        addButton = new JButton("Add Appointment");
        addButton.setBounds(270, 180, 180, 35);
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

        add(patientBox);
        add(doctorBox);
        add(dateField);
        add(addButton);

        loadData();

        addButton.addActionListener((ActionEvent e) -> {
            try {
                Patient p = (Patient) patientBox.getSelectedItem();
                Doctor d = (Doctor) doctorBox.getSelectedItem();
                Date date = Date.valueOf(dateField.getText());

                Appointment a = new Appointment(0, p, d, date);
                new AppointmentDAO().addAppointment(a);

                JOptionPane.showMessageDialog(this, "Appointment Added Successfully!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Date Format. Please use YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }

    private void loadData() {
        List<Patient> patients = new PatientDAO().getAllPatients();
        for (Patient p : patients) {
            patientBox.addItem(p);
        }

        List<Doctor> doctors = new DoctorDAO().getAllDoctors();
        for (Doctor d : doctors) {
            doctorBox.addItem(d);
        }
    }
}