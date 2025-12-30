package Hospital.Management.Application.controller;

import Hospital.Management.Application.models.Bill;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import Hospital.Management.Application.service.billService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bill")
@AllArgsConstructor
public class billController {
    billService billService;
    @GetMapping
    List<Bill> getAllBills(){
        return billService.getAllBills();
    }

    @GetMapping("/{id}")
    Bill getBillById(@PathVariable Long id){
        return billService.getBillById(id);
    }

    @PostMapping("/generate/{id}")
    Bill generateBill(@PathVariable Long id){
        return billService.generateBill(id);
    }
}
