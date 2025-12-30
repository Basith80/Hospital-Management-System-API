package Hospital.Management.Application.service;

import Hospital.Management.Application.models.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import Hospital.Management.Application.repository.appointmentRepository;
import Hospital.Management.Application.repository.patientRepository;
import Hospital.Management.Application.repository.doctorRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class appointmentService {
    private appointmentRepository appointmentRepository;
    private patientRepository patientRepository;
    private doctorRepository doctorRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }

    public void createAppointment(Appointment appointment) {
        // 1️⃣ Check patient exists
        if(!patientRepository.existsById(appointment.getPatientId())){
            throw new RuntimeException("Patient not registered / not found");
        }

        // 2️⃣ Check doctor exists
        if(!doctorRepository.existsById(appointment.getDoctorId())){
            throw new RuntimeException("Doctor not found");
        }

        // 3️⃣ Validate date
        if (appointment.getStartDate().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Date and Time not valid");
        }

        // 4️⃣ Check doctor availability
        if (appointmentRepository.existsByDoctorIdAndStartDate(appointment.getDoctorId() , appointment.getStartDate())){
            throw new RuntimeException("Doctor already has an appointment at this time");
        }

        // 5️⃣ Auto-calculate end time (15 minutes)
        appointment.setEndDate(appointment.getStartDate().plusMinutes(20));

        // 6️⃣ Save appointment
        appointmentRepository.save(appointment);

    }

    public void updateAppointment(Appointment appointment , Long id) {
       Appointment existingAppointment = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment Not found"));

        existingAppointment.setStartDate(appointment.getStartDate());
        existingAppointment.setEndDate(appointment.getStartDate().plusMinutes(15));
        existingAppointment.setDiagnostic(appointment.isDiagnostic());
        existingAppointment.setMedicine(appointment.isMedicine());
        existingAppointment.setRoom(appointment.isRoom());

        appointmentRepository.save(existingAppointment);
    }
}
