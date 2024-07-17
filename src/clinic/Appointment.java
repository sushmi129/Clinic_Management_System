package clinic;

public class Appointment {
    private int id;
    private int patientId;
    private String appointmentDate;
    private String doctorName;
    private String status;

    public Appointment(int id, int patientId, String appointmentDate, String doctorName, String status) {
        this.id = id;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

