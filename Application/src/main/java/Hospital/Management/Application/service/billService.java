package Hospital.Management.Application.service;

import Hospital.Management.Application.models.Appointment;
import Hospital.Management.Application.repository.appointmentRepository;
import Hospital.Management.Application.repository.billRepository;
import Hospital.Management.Application.models.Bill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class billService {
    billRepository billRepository;
    appointmentRepository appointmentRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill generateBill(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        double amount = 500;

        if(appointment.isDiagnostic()){
            amount+=1000;
        }
        if(appointment.isRoom()){
            amount+=1500;
        }
        if(appointment.isMedicine()){
            amount+=800;
        }
        Bill bill = new Bill();
        bill.setBillAmount(amount);
        bill.setDoctorId(appointment.getDoctorId());
        bill.setPatientId(appointment.getPatientId());
        return billRepository.save(bill);
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElseThrow(()-> new RuntimeException("Invalid Input"));
    }
}
