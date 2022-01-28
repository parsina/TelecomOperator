package com.demo.telecom.service;

import com.demo.telecom.exception.ResourceNotFoundException;
import com.demo.telecom.model.PhoneNumber;

import java.util.List;

public interface OperatorService {
    List<PhoneNumber> getAllPhoneNumbers();
    List<PhoneNumber> getPhoneNumbers( Long customerId);
    PhoneNumber activatePhoneNumber(Long phoneNumberId) throws ResourceNotFoundException;
}
