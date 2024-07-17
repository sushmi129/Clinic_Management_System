package clinic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDAO {
    private Connection connection;

    public MedicalRecordDAO() throws SQLException {
        this.connection = DBconnection.getConnection();
    }

    public void addMedicalRecord(MedicalRecord record) throws SQLException {
        String query = "INSERT INTO medical_records (patient_id, diagnosis, treatment, date) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, record.getPatientId());
        stmt.setString(2, record.getDiagnosis());
        stmt.setString(3, record.getTreatment());
        stmt.setString(4, record.getDate());
        stmt.executeUpdate();
    }

    public List<MedicalRecord> getAllMedicalRecords() throws SQLException {
        List<MedicalRecord> records = new ArrayList<>();
        String query = "SELECT * FROM medical_records";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("record_id");
            int patientId = rs.getInt("patient_id");
            String diagnosis = rs.getString("diagnosis");
            String treatment = rs.getString("treatment");
            String date = rs.getString("date");
            records.add(new MedicalRecord(id, patientId, diagnosis, treatment, date));
        }
        return records;
    }

    public void updateMedicalRecord(MedicalRecord record) throws SQLException {
        String query = "UPDATE medical_records SET patient_id = ?, diagnosis = ?, treatment = ?, date = ? WHERE record_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, record.getPatientId());
        stmt.setString(2, record.getDiagnosis());
        stmt.setString(3, record.getTreatment());
        stmt.setString(4, record.getDate());
        stmt.setInt(5, record.getId());
        stmt.executeUpdate();
    }

    public void deleteMedicalRecord(int recordId) throws SQLException {
        String query = "DELETE FROM medical_records WHERE record_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, recordId);
        stmt.executeUpdate();
    }
}

