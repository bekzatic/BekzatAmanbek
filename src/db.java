import java.sql.*;
import java.util.Scanner;
public class db {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "bekzat31";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM patient");
            System.out.println("\nAll patients:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("patient_id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("age") + " " +
                                rs.getString("diagnosis")
                );
            }
            rs = stmt.executeQuery("SELECT * FROM patient WHERE age > 25");
            System.out.println("\nPatients older than 25:");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("age"));
            }
            rs = stmt.executeQuery("SELECT COUNT(*) FROM patient");
            if (rs.next()) {
                System.out.println("\nTotal patients: " + rs.getInt(1));
            }
            rs = stmt.executeQuery("SELECT AVG(age) FROM patient");
            if (rs.next()) {
                System.out.println("Average age: " + rs.getDouble(1));
            }

            stmt.executeUpdate("UPDATE patient SET diagnosis='Recovered' WHERE patient_id = 302");
            System.out.println("\nPatient 302 updated");
            stmt.executeUpdate("DELETE FROM patient WHERE patient_id = 301");
            System.out.println("Patient 301 deleted");rs = stmt.executeQuery("SELECT * FROM medical_professional WHERE age > 30");
            System.out.println("\nMedical professionals older than 30:");
            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " " + rs.getInt("age") + " " + rs.getString("specialization")
                );
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("\nResources closed properly");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
