package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReceptionistDashboard extends JFrame {

    JButton patientBtn, appointmentBtn, viewBtn;

    public ReceptionistDashboard() {

        getContentPane().setBackground(new Color(245, 249, 255));
        setTitle("Clinic Dashboard");
        setSize(900, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        Font btnFont = new Font("Segoe UI", Font.BOLD, 13);
        Color primaryBlue = new Color(0, 102, 204);
        int btnWidth = 200;
        int btnHeight = 40;
        int centerX = (900 / 2) - (btnWidth / 2);

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

        patientBtn = new JButton("Patient Form");
        appointmentBtn = new JButton("Appointment");
        viewBtn = new JButton("View Patients");

        JButton[] buttons = {patientBtn, appointmentBtn, viewBtn};
        int startY = 70;

        for (JButton btn : buttons) {
            btn.setBounds(centerX, startY, btnWidth, btnHeight);
            btn.setFont(btnFont);
            btn.setBackground(Color.WHITE);
            btn.setForeground(primaryBlue);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(primaryBlue, 1));

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
            startY += 65;
        }

        patientBtn.addActionListener(e -> new PatientForm());
        appointmentBtn.addActionListener(e -> new AppointmentForm());
        viewBtn.addActionListener(e -> new ViewPatientsUI());

        setVisible(true);
    }
}