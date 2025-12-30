package Hospital.Management.Application.service;

import Hospital.Management.Application.models.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import Hospital.Management.Application.repository.doctorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class doctorService {
    doctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public void updateDoctor(Doctor doctor, Long id) {
        if (doctorRepository.existsById(id)) {
            doctor.setDoctorId(id);
            doctorRepository.save(doctor);
        }
    }
}
