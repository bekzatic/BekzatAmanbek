import java.util.Objects;

public class Hospital implements Comparable<Hospital> {
    private String hospitalName;
    private String location;
    private int capacity;

    public Hospital(String hospitalName, String location, int capacity) {
        this.hospitalName = hospitalName;
        this.location = location;
        this.capacity = capacity;
    }

    public String getHospitalName() { return hospitalName; }
    public int getCapacity() { return capacity; }

    @Override
    public int compareTo(Hospital other) {
        return Integer.compare(this.capacity, other.capacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hospital)) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(hospitalName, hospital.hospitalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalName);
    }

    @Override
    public String toString() {
        return "Hospital [Name=" + hospitalName +
                ", Location=" + location +
                ", Capacity=" + capacity + "]";
    }
}