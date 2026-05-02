package dao;

import db.DBConnection;
import model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    // 🔹 Add Doctor
    public void addDoctor(Doctor d) {

        String query = "INSERT INTO doctors (name, specialization) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, d.getName());
            ps.setString(2, d.getSpecialization());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 Get All Doctors
    public List<Doctor> getAllDoctors() {

        List<Doctor> list = new ArrayList<>();
        String query = "SELECT * FROM doctors";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {

                Doctor d = new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("name"),
                        rs.getString("specialization")
                );

                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}