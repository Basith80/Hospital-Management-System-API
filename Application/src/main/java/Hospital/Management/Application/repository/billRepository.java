package Hospital.Management.Application.repository;

import Hospital.Management.Application.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface billRepository extends JpaRepository<Bill , Long> {
}
