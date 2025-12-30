package Hospital.Management.Application.repository;

import Hospital.Management.Application.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface doctorRepository extends JpaRepository<Doctor, Long> {
}
