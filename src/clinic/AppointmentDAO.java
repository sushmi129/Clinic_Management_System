package clinic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private Connection connection;

    public AppointmentDAO() throws SQLException {
        this.connection = DBconnection.getConnection();
    }

    public void addAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO appointments (patient_id, appointment_date, doctor_name, status) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, appointment.getPatientId());
        stmt.setString(2, appointment.getAppointmentDate());
        stmt.setString(3, appointment.getDoctorName());
        stmt.setString(4, appointment.getStatus());
        stmt.executeUpdate();
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("appointment_id");
            int patientId = rs.getInt("patient_id");
            String appointmentDate = rs.getString("appointment_date");
            String doctorName = rs.getString("doctor_name");
            String status = rs.getString("status");
            appointments.add(new Appointment(id, patientId, appointmentDate, doctorName, status));
        }
        return appointments;
    }

    public void updateAppointment(Appointment appointment) throws SQLException {
        String query = "UPDATE appointments SET patient_id = ?, appointment_date = ?, doctor_name = ?, status = ? WHERE appointment_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, appointment.getPatientId());
        stmt.setString(2, appointment.getAppointmentDate());
        stmt.setString(3, appointment.getDoctorName());
        stmt.setString(4, appointment.getStatus());
        stmt.setInt(5, appointment.getId());
        stmt.executeUpdate();
    }

    public void deleteAppointment(int appointmentId) throws SQLException {
        String query = "DELETE FROM appointments WHERE appointment_id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, appointmentId);
        stmt.executeUpdate();
    }
}

