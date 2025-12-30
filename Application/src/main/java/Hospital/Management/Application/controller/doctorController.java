package Hospital.Management.Application.controller;

import Hospital.Management.Application.models.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import Hospital.Management.Application.service.doctorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
public class doctorController {
    doctorService doctorService;
    @GetMapping
    List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    Optional<Doctor> getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }

    @PostMapping("/addDoctor")
    void addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
    }

    @PutMapping("/update/{id}")
    void updateDoctor(@RequestBody Doctor doctor , @PathVariable Long id){
        doctorService.updateDoctor(doctor , id);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
    }
}
