package clinic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private Connection connection;

    public PatientDAO() throws SQLException {
        this.connection = DBconnection.getConnection();
    }

    public void addPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patients (name, date_of_birth, gender, contact_info) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, patient.getName());
        stmt.setString(2, patient.getDateOfBirth());
        stmt.setString(3, patient.getGender());
        stmt.setString(4, patient.getContactInfo());
        stmt.executeUpdate();
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("patient_id");
            String name = rs.getString("name");
            String dateOfBirth = rs.getString("date_of_birth");
            String gender = rs.getString("gender");
            String contactInfo = rs.getString("contact_info");
            patients.add(new Patient(id, name, dateOfBirth, gender, contactInfo));
        }
        return patients;
    }

    public void updatePatient(Patient patient) throws SQLException {
        String query = "UPDATE patients SET name = ?, date_of_birth = ?, gender = ?, contact_info = ? WHERE patient_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, patient.getName());
        stmt.setString(2, patient.getDateOfBirth());
        stmt.setString(3, patient.getGender());
        stmt.setString(4, patient.getContactInfo());
        stmt.setInt(5, patient.getId());
        stmt.executeUpdate();
    }

    public void deletePatient(int patientId) throws SQLException {
        String query = "DELETE FROM patients WHERE patient_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, patientId);
        stmt.executeUpdate();
    }
}

