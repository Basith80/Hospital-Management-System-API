package Hospital.Management.Application.controller;

import Hospital.Management.Application.models.Patient;
import Hospital.Management.Application.service.patientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/patient")
public class patientController {
    patientService patientService;
    @GetMapping
    List<Patient> getAllPatients(){
      return  patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    Patient getPatientById(@PathVariable Long id){
        return  patientService.getPatientById(id);
    }

    @PostMapping("/addPatient")
    void addPatient(@RequestBody Patient patient ){
        patientService.addPatient(patient);
    }

    @PutMapping("/update/{id}")
    void updatePatient(@RequestBody Patient patient , @PathVariable Long id){
        patientService.updatePatient(patient , id);
    }

    @DeleteMapping("/deletePatient/{id}")
    void deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
    }

}
