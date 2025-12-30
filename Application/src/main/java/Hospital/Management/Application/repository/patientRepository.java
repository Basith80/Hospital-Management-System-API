package Hospital.Management.Application.repository;

import Hospital.Management.Application.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepository extends JpaRepository<Patient , Long> {
}
