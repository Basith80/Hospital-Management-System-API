🏥 Hospital Management System API
A modern, RESTful backend application built with Spring Boot 3.x to manage hospital operations. This system handles the lifecycle of patient visits, from registration and doctor scheduling to automated bill generation.

🚀 Features
Patient Management: Full CRUD operations for managing patient profiles and medical history.
Doctor Directory: Maintain a database of medical specialists and their departments.
Smart Appointments:
Appointment scheduling with conflict detection.
Prevents double-booking by checking doctor availability for specific time slots.
Automated Billing Engine:
Automatically calculates totals based on services rendered.
Factors in base fees, diagnostic costs, room charges, and medicine expenses.
Data Integrity: Uses Jakarta Persistence (JPA) for reliable database mapping.
🛠️ Tech Stack
Java 17/21
Spring Boot 3.4+
Spring Data JPA (Persistence Layer)
Lombok (Code reduction)
H2/MySQL/PostgreSQL (Database)
Maven (Dependency Management)

📂 Project Structure
text
src/main/java/Hospital/Management/Application/
├── models/         # Database Entities (Patient, Doctor, Appointment, Bill)
├── repository/     # Data Access Layer (JpaRepository interfaces)
├── service/        # Business Logic (Billing logic & validation)
└── Application.java # Main Entry Point
Use code with caution.

⚙️ Installation & Setup
Clone the repository:
bash
git clone github.com
cd Hospital-Management-System-API
Use code with caution.

Configure Database:
Update src/main/resources/application.properties with your database credentials:
properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Use code with caution.

Build and Run:
bash
mvn clean install
mvn spring-boot:run
Use code with caution.

🔌 API Endpoints (Quick Reference)
Patients
GET /api/v1/patient - Get all patients
POST /api/v1/patient - Register a new patient
DELETE /api/v1/patient/{id} - Remove a patient record
Appointments
POST /api/v1/appointment - Book a new appointment
GET /api/v1/appointment - View all schedules
Billing
POST /api/v1/bill/generate/{appointmentId} - Generate a final bill based on appointment details.

📝 Billing Logic
The system uses a base fee of 500 and adds the following based on the appointment checkboxes:
Diagnostics: +1000
Room Charges: +1500
Medicine: +800  


Developed by [Abdul Basith. A]
Connect with me on [[Basith](https://www.linkedin.com/in/abdul-basith-abudhahir-956a162a5/overlay/about-this-profile/?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base%3BFIu2ySIYQP6aI23N0YQREg%3D%3D)]

