package Hospital.Management.Application.repository;

import Hospital.Management.Application.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

public interface appointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByDoctorIdAndStartDate(Long doctorId, LocalDateTime startDate);
}
