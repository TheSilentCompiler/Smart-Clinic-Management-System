package model;

public class Doctor extends Person{
    private int doctorId;
    private String specialization;

    // Constructors
    public Doctor() {}

    public Doctor(int doctorId, String name, String specialization) {
        super(name);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    // Getters & Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // toString
    @Override
    public String toString() {
        return name + " - " + specialization;
    }

    @Override
    public void showDetails() {
        System.out.println("Doctor: " + name + ", Specialization: " + specialization);
    }
}