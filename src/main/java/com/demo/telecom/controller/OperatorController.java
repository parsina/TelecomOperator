package com.demo.telecom.controller;

import com.demo.telecom.exception.ResourceNotFoundException;
import com.demo.telecom.model.PhoneNumber;
import com.demo.telecom.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OperatorController {

    private final OperatorService operatorService;

    @Autowired
    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping("/phoneNumbers")
    public List<PhoneNumber> getAllPhoneNumbers() {
        return operatorService.getAllPhoneNumbers();
    }

    @GetMapping("/phoneNumbers/{customer_id}")
    public List<PhoneNumber> getPhoneNumbersByCustomer(@PathVariable(value = "customer_id") Long customerId) throws ResourceNotFoundException {
        return operatorService.getPhoneNumbers(customerId);
    }

    @PutMapping("/phoneNumbers/{id}")
    public PhoneNumber activatePhoneNumber(@PathVariable(value = "id") Long phoneNumberId) throws ResourceNotFoundException {
        return operatorService.activatePhoneNumber(phoneNumberId);
    }
}
