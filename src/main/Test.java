import dao.PatientDAO;
import model.Patient;
import model.Person;

import java.util.List;

public class Test {
    public static void main(String[] args) {

//        PatientDAO dao = new PatientDAO();
//
//        // 🔹 Add patient
//        dao.addPatient(new Patient(0, "Bilal", 20, "Male", "03000000000"));
//
//        // 🔹 Fetch all patients
//        List<Patient> list = dao.getAllPatients();
//
//        for (Patient p : list) {
//            System.out.println(p);
//        }

        Person p = new Patient(1, "Ali", 20, "Male", "123");
        p.showDetails();
    }
}