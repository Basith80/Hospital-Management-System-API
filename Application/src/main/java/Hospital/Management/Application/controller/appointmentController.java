package Hospital.Management.Application.controller;

import Hospital.Management.Application.models.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import Hospital.Management.Application.service.appointmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
@AllArgsConstructor
public class appointmentController {
    private appointmentService appointmentService;
    @GetMapping
    List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }
    @GetMapping("/{id}")
    Optional<Appointment> getAppointmentById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }
    @DeleteMapping("/delete/{id}")
    void deleteAppointmentById(@PathVariable Long id){
        appointmentService.deleteAppointmentById(id);
    }

    @PostMapping("/create")
    void createAppointment(@RequestBody Appointment appointment){
        appointmentService.createAppointment(appointment);
    }

    @PutMapping("/update/{id}")
    void updateAppointment(@RequestBody Appointment appointment , @PathVariable Long id){
        appointmentService.updateAppointment(appointment , id);
    }
}
