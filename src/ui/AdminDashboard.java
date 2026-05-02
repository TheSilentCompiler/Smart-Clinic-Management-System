package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminDashboard extends JFrame {

    JButton patientBtn, doctorBtn, appointmentBtn, viewBtn;

    public AdminDashboard() {
        getContentPane().setBackground(new Color(245, 249, 255));
        setTitle("Clinic Dashboard");
        setSize(900, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font btnFont = new Font("Segoe UI", Font.BOLD, 13);
        Color primaryBlue = new Color(0, 102, 204);
        Color hoverBlue = new Color(0, 153, 255); // Lighter blue for hover

        int btnWidth = 200;
        int btnHeight = 40;
        int centerX = (900 / 2) - (btnWidth / 2);

        patientBtn = new JButton("Patient Form");
        doctorBtn = new JButton("Doctor Form");
        appointmentBtn = new JButton("Appointment");
        viewBtn = new JButton("View Patients");

        JButton[] buttons = {patientBtn, doctorBtn, appointmentBtn, viewBtn};
        int startY = 50;

        for (JButton btn : buttons) {
            btn.setBounds(centerX, startY, btnWidth, btnHeight);
            btn.setFont(btnFont);
            btn.setBackground(Color.WHITE);
            btn.setForeground(primaryBlue);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(primaryBlue, 1));

            // Adding  Hover Effect
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(primaryBlue);
                    btn.setForeground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(Color.WHITE);
                    btn.setForeground(primaryBlue);
                }
            });

            add(btn);
            startY += 55;
        }

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/doctor-male.png"));
        Image i2 = imageIcon2.getImage().getScaledInstance(240, 240, Image.SCALE_SMOOTH);
        JLabel label1 = new JLabel(new ImageIcon(i2));
        label1.setBounds(30, 40, 240, 240);
        add(label1);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/doctor-female.png"));
        Image i1 = imageIcon1.getImage().getScaledInstance(240, 240, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(i1));
        label.setBounds(610, 40, 240, 240);
        add(label);

        patientBtn.addActionListener(e -> new PatientForm());
        doctorBtn.addActionListener(e -> new DoctorForm());
        appointmentBtn.addActionListener(e -> new AppointmentForm());
        viewBtn.addActionListener(e -> new ViewPatientsUI());

        setVisible(true);
    }
}