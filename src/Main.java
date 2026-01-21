import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Patient(101,"Bekzat",17,"Astigmatism"));
        people.add(new Patient(102,"Nurislam",24,"Diabetes"));
        people.add(new MedicalProfessional(201,"Dr. Smith",35,"Cardiology"));
        people.add(new MedicalProfessional(202,"Dr. Strange",44,"Surgeon"));

        // Polymorphism
        for (Person p : people) {
            p.displayInfo();
        }

        // Searching
        System.out.println("\nSearching for person named Bekzat:");
        for (Person p : people) {
            if (p.getName().equals("Bekzat")) {
                System.out.println(p);
            }
        }

        // Filtering
        System.out.println("\nPeople older than 30:");
        people.stream()
                .filter(p -> p.getAge() > 30)
                .forEach(System.out::println);

        // Sorting
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(103,"Ali",20,"Flu"));
        patients.add(new Patient(104,"Dana",30,"Cold"));
        Collections.sort(patients);

        System.out.println("\nSorted patients by age:");
        patients.forEach(System.out::println);
    }
}