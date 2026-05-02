package model;

public class Patient extends Person{
    private int patientId;
    private int age;
    private String gender;
    private String phone;

    // Constructors
    public Patient() {

    }

    public Patient(int patientId, String name, int age, String gender, String phone) {
        super(name); // calling parent constructor
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    // Getters & Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString
    @Override
    public String toString() {
        return name + " (" + age + ", " + gender + ")";
    }

    @Override
    public void showDetails() {
        System.out.println("Patient: " + name + ", Age: " + age);
    }
}