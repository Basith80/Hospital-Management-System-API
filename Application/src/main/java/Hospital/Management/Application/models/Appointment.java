package Hospital.Management.Application.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long appointmentId;
    Long patientId;
    Long doctorId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    boolean diagnostic;
    boolean medicine;
    boolean room;

}
