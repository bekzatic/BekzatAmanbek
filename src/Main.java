import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "bekzat31";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            Statement stmt = conn.createStatement();
            System.out.println("Connected to database");

            // ========== INSERT много данных ==========
            stmt.executeUpdate("INSERT INTO patient VALUES (201, 'Amina', 19, 'Cold')");
            stmt.executeUpdate("INSERT INTO patient VALUES (202, 'Dias', 28, 'Flu')");
            stmt.executeUpdate("INSERT INTO patient VALUES (203, 'Madina', 35, 'Headache')");
            stmt.executeUpdate("INSERT INTO patient VALUES (204, 'Arman', 42, 'Diabetes')");
            stmt.executeUpdate("INSERT INTO patient VALUES (205, 'Alina', 23, 'Asthma')");

            System.out.println("Inserted multiple patients.");

            // ========== SELECT ALL ==========
            System.out.println("\nAll patients:");
            ResultSet rs = stmt.executeQuery("SELECT * FROM patient");
            while (rs.next()) {
                System.out.println(rs.getInt("patient_id") + " "
                        + rs.getString("name") + " "
                        + rs.getInt("age") + " "
                        + rs.getString("diagnosis"));
            }

            // ========== SELECT with WHERE ==========
            System.out.println("\nPatients older than 25:");
            rs = stmt.executeQuery("SELECT * FROM patient WHERE age > 25");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("age"));
            }

            // ========== SELECT with ORDER BY ==========
            System.out.println("\nSorted by age:");
            rs = stmt.executeQuery("SELECT * FROM patient ORDER BY age ASC");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("age"));
            }

            // ========== SELECT with COUNT ==========
            rs = stmt.executeQuery("SELECT COUNT(*) FROM patient");
            if (rs.next()) {
                System.out.println("\nTotal patients: " + rs.getInt(1));
            }

            // ========== SELECT with AVG ==========
            rs = stmt.executeQuery("SELECT AVG(age) FROM patient");
            if (rs.next()) {
                System.out.println("Average age: " + rs.getDouble(1));
            }

            // ========== UPDATE ==========
            stmt.executeUpdate("UPDATE patient SET diagnosis = 'Recovered' WHERE patient_id = 202");
            System.out.println("\nUpdated patient 202");

            // ========== DELETE ==========
            stmt.executeUpdate("DELETE FROM patient WHERE patient_id = 201");
            System.out.println("Deleted patient 201");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
