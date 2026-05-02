package dao;

import db.DBConnection;
import model.Appointment;
import model.Patient;
import model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    // 🔹 Add Appointment
    public void addAppointment(Appointment a) {

        String query = "INSERT INTO appointments (patient_id, doctor_id, appointment_date) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, a.getPatient().getPatientId());
            ps.setInt(2, a.getDoctor().getDoctorId());
            ps.setDate(3, a.getAppointmentDate());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 Get All Appointments (FULL JOIN STYLE)
    public List<Appointment> getAllAppointments() {

        List<Appointment> list = new ArrayList<>();

        String query =
                "SELECT a.appointment_id, a.appointment_date, " +
                        "p.patient_id, p.name AS patient_name, p.age, p.gender, p.phone, " +
                        "d.doctor_id, d.name AS doctor_name, d.specialization " +
                        "FROM appointments a " +
                        "JOIN patients p ON a.patient_id = p.patient_id " +
                        "JOIN doctors d ON a.doctor_id = d.doctor_id";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {

                Patient p = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("patient_name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("phone")
                );

                Doctor d = new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("doctor_name"),
                        rs.getString("specialization")
                );

                Appointment a = new Appointment(
                        rs.getInt("appointment_id"),
                        p,
                        d,
                        rs.getDate("appointment_date")
                );

                list.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}