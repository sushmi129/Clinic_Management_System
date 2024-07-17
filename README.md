# Clinic Management System

This is a console-based Clinic Management System implemented in Java using JDBC and MySQL. The application allows users to manage patients, appointments, and medical records for a healthcare provider.

## Features

- **Patient Management**
  - Add a new patient
  - View patient details
  - Update patient information
  - Delete a patient

- **Appointment Management**
  - Schedule a new appointment
  - View appointment details
  - Update appointment information
  - Cancel an appointment

- **Medical Record Management**
  - Add a new medical record
  - View medical record details
  - Update medical record information
  - Delete a medical record

## Database Schema

- **Patient Table**
  - `patient_id` (Primary Key)
  - `name`
  - `date_of_birth`
  - `gender`
  - `contact_info`

- **Appointment Table**
  - `appointment_id` (Primary Key)
  - `patient_id` (Foreign Key references Patient Table)
  - `appointment_date`
  - `doctor_name`
  - `status` (scheduled/completed/cancelled)

- **Medical Record Table**
  - `record_id` (Primary Key)
  - `patient_id` (Foreign Key references Patient Table)
  - `diagnosis`
  - `treatment`
  - `date`

## Setup

### Prerequisites

- Java Development Kit (JDK) installed (version 8 or higher)
- MySQL database installed and running
- MySQL JDBC driver (download from https://dev.mysql.com/downloads/connector/j/)

### Steps

1. **Clone the repository**

   ```sh
   git clone <repository-url>
   cd clinic-management-system

   
2. **Create the MySQL Database**


3. **Configure the database connection**

    -Open DBConnection.java and update the database connection details:

4. **Build and Run the Application**

      -Open the project in your IDE (e.g., Eclipse) and run the ClinicManagementSystem.java class.

## Usage

Once the application is running, follow the prompts in the console to manage patients, appointments, and medical records.

### Patient Management

- Choose option 1 to manage patients.
- Follow the prompts to add, view, update, or delete a patient.

### Appointment Management

- Choose option 2 to manage appointments.
- Follow the prompts to schedule, view, update, or cancel an appointment.

### Medical Record Management

- Choose option 3 to manage medical records.
- Follow the prompts to add, view, update, or delete a medical record.

### Exit

- Choose option 4 to exit the application.




