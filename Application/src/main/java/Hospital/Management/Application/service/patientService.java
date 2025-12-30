package Hospital.Management.Application.service;

import Hospital.Management.Application.models.Patient;
import Hospital.Management.Application.repository.patientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class patientService {
 patientRepository patientRepository;
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)){
        patientRepository.deleteById(id);}
        else {
            System.out.println("The id is not valid");
        }
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
    }

    public void updatePatient(Patient patient, Long id) {
        if(patientRepository.existsById(id)) {
            patient.setPatientId(id);
            patientRepository.save(patient);
        }
    }
}
