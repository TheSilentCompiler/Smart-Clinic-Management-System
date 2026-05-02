package ui;

import dao.PatientDAO;
import model.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class ViewPatientsUI extends JFrame {

    JTable table;

    public ViewPatientsUI() {

        getContentPane().setBackground(new Color(245, 249, 255));
        setTitle("All Patients Records");
        setSize(800, 450);
        setLocationRelativeTo(null);

        table = new JTable();
        table.setRowHeight(30);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setGridColor(new Color(230, 230, 230));
        table.setSelectionBackground(new Color(0, 102, 204));
        table.setSelectionForeground(Color.WHITE);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(0, 102, 204));
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(100, 35));

        JScrollPane pane = new JScrollPane(table);
        pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pane.getViewport().setBackground(Color.WHITE);

        add(pane, BorderLayout.CENTER);

        loadData();

        setVisible(true);
    }

    private void loadData() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only for professional look
            }
        };

        model.setColumnIdentifiers(new String[]{"ID", "Name", "Age", "Gender", "Phone Number"});

        List<Patient> list = new PatientDAO().getAllPatients();

        for (Patient p : list) {
            model.addRow(new Object[]{
                    p.getPatientId(),
                    p.getName(),
                    p.getAge(),
                    p.getGender(),
                    p.getPhone()
            });
        }

        table.setModel(model);
    }
}