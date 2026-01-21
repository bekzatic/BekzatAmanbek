public class MedicalProfessional extends Person {
    private int staffId;
    private String specialization;

    public MedicalProfessional(int staffId, String name, int age, String specialization) {
        super(name, age);
        this.staffId = staffId;
        this.specialization = specialization;
    }

    public int getStaffId() { return staffId; }

    @Override
    public void displayInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "MedicalProfessional [ID=" + staffId +
                ", Name=" + name +
                ", Age=" + age +
                ", Specialization=" + specialization + "]";
    }
}