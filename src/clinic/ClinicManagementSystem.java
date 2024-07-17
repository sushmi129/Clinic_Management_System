package clinic;

import java.util.List;
import java.util.Scanner;

public class ClinicManagementSystem {
    private static PatientDAO patientDAO;
    private static AppointmentDAO appointmentDAO;
    private static MedicalRecordDAO medicalRecordDAO;

    public static void main(String[] args) {
        try {
            patientDAO = new PatientDAO();
            appointmentDAO = new AppointmentDAO();
            medicalRecordDAO = new MedicalRecordDAO();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Clinic Management System");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("1. Patient Management");
                System.out.println("2. Appointment Management");
                System.out.println("3. Medical Record Management");
                System.out.println("4. Exit");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                switch (choice) {
                    case 1:
                        patientManagement(scanner);
                        break;
                    case 2:
                        appointmentManagement(scanner);
                        break;
                    case 3:
                        medicalRecordManagement(scanner);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void patientManagement(Scanner scanner) {
        System.out.println("1. Add a new patient");
        System.out.println("2. View patient details");
        System.out.println("3. Update patient information");
        System.out.println("4. Delete a patient");
        System.out.println("5. Back....");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
            case 1:
                addPatient(scanner);
                break;
            case 2:
                viewAllPatients();
                break;
            case 3:
                updatePatient(scanner);
                break;
            case 4:
                deletePatient(scanner);
                break;
            case 5:
            	break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();
        Patient patient = new Patient(0, name, dateOfBirth, gender, contactInfo);
        try {
            patientDAO.addPatient(patient);
            System.out.println("----------------------Patient added successfully.----------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void viewAllPatients() {
        try {
            List<Patient> patients = patientDAO.getAllPatients();
            if(patients.size() == 0) {
            	System.out.println("--------------------------No Patients------------------------------------------------");
            }
            System.out.println("Patient ID \t\t\t Patient Name \t\t\t Date Of Birth \t\t\t Gender \t\t\t Contact INFO" );
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Patient patient : patients) {
                System.out.println(patient.getId() + "\t\t\t\t" + patient.getName() + "\t\t\t" + patient.getDateOfBirth() + "\t\t\t" + patient.getGender() + "\t\t\t" + patient.getContactInfo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updatePatient(Scanner scanner) {
        System.out.print("Enter patient ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter new gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter new contact info: ");
        String contactInfo = scanner.nextLine();
        Patient patient = new Patient(id, name, dateOfBirth, gender, contactInfo);
        try {
            patientDAO.updatePatient(patient);
            System.out.println("-----------------Patient updated successfully.--------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deletePatient(Scanner scanner) {
        System.out.print("Enter patient ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            patientDAO.deletePatient(id);
            System.out.println("----------------------Patient deleted successfully.----------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void appointmentManagement(Scanner scanner) {
        System.out.println("1. Schedule a new appointment");
        System.out.println("2. View appointment details");
        System.out.println("3. Update appointment information");
        System.out.println("4. Cancel an appointment");
        System.out.println("5. Back....");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
            case 1:
                addAppointment(scanner);
                break;
            case 2:
                viewAllAppointments();
                break;
            case 3:
                updateAppointment(scanner);
                break;
            case 4:
                deleteAppointment(scanner);
                break;
            case 5:
            	break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void addAppointment(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String appointmentDate = scanner.nextLine();
        System.out.print("Enter doctor name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter status (scheduled/completed/cancelled): ");
        String status = scanner.nextLine();
        Appointment appointment = new Appointment(0, patientId, appointmentDate, doctorName, status);
        try {
            appointmentDAO.addAppointment(appointment);
            System.out.println("--------------------Appointment scheduled successfully.-------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void viewAllAppointments() {
        try {
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
            if(appointments.size() == 0) {
            	System.out.println("---------------------------No Appointments------------------------------");
            }
            System.out.println("Appointment ID \t\t Patient ID \t\t Appointment Date \t\t Doctor Name \t\t Status");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            for (Appointment appointment : appointments) {
                System.out.println(appointment.getId() + "\t\t\t" + appointment.getPatientId() + "\t\t\t" + appointment.getAppointmentDate() + "\t\t\t" + appointment.getDoctorName() + "\t\t" + appointment.getStatus());
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateAppointment(Scanner scanner) {
        System.out.print("Enter appointment ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new appointment date (YYYY-MM-DD): ");
        String appointmentDate = scanner.nextLine();
        System.out.print("Enter new doctor name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter new status (scheduled/completed/cancelled): ");
        String status = scanner.nextLine();
        Appointment appointment = new Appointment(id, patientId, appointmentDate, doctorName, status);
        try {
            appointmentDAO.updateAppointment(appointment);
            System.out.println("-------------------Appointment updated successfully.----------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteAppointment(Scanner scanner) {
        System.out.print("Enter appointment ID to cancel: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        try {
            appointmentDAO.deleteAppointment(id);
            System.out.println("-----------------------------------Appointment cancelled successfully.----------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void medicalRecordManagement(Scanner scanner) {
        System.out.println("1. Add a new medical record");
        System.out.println("2. View medical record details");
        System.out.println("3. Update medical record information");
        System.out.println("4. Delete a medical record");
        System.out.println("5. Back....");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
            case 1:
                addMedicalRecord(scanner);
                break;
            case 2:
                viewAllMedicalRecords();
                break;
            case 3:
                updateMedicalRecord(scanner);
                break;
            case 4:
                deleteMedicalRecord(scanner);
                break;
            case 5:
            	break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void addMedicalRecord(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.print("Enter diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter treatment: ");
        String treatment = scanner.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        MedicalRecord record = new MedicalRecord(0, patientId, diagnosis, treatment, date);
        try {
            medicalRecordDAO.addMedicalRecord(record);
            System.out.println("-----------------------------Medical record added successfully.----------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void viewAllMedicalRecords() {
        try {
            List<MedicalRecord> records = medicalRecordDAO.getAllMedicalRecords();
            if(records.size() == 0) {
            	System.out.println("--------------------No Records--------------------------------");
            }
            System.out.println("Record ID \t\t Patient ID \t\t Diagnosis \t\t Treatment \t\t Date");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            for (MedicalRecord record : records) {
                System.out.println(record.getId() + "\t\t\t" + record.getPatientId() + "\t\t\t" + record.getDiagnosis() + "\t\t" + record.getTreatment() + "\t\t" + record.getDate());
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateMedicalRecord(Scanner scanner) {
        System.out.print("Enter medical record ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter new treatment: ");
        String treatment = scanner.nextLine();
        System.out.print("Enter new date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        MedicalRecord record = new MedicalRecord(id, patientId, diagnosis, treatment, date);
        try {
            medicalRecordDAO.updateMedicalRecord(record);
            System.out.println("--------------------Medical record updated successfully.---------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteMedicalRecord(Scanner scanner) {
        System.out.print("Enter medical record ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        try {
            medicalRecordDAO.deleteMedicalRecord(id);
            System.out.println("--------------------------Medical record deleted successfully.---------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

