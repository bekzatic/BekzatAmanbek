public class Patient extends Person implements Comparable<Patient> {
    private int patientId;
    private String diagnosis;

    public Patient(int patientId, String name, int age, String diagnosis) {
        super(name, age);
        this.patientId = patientId;
        this.diagnosis = diagnosis;
    }

    public int getPatientId() { return patientId; }
    public String getDiagnosis() { return diagnosis; }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public void displayInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Patient [ID=" + patientId +
                ", Name=" + name +
                ", Age=" + age +
                ", Diagnosis=" + diagnosis + "]";
    }
}