package com.demo.telecom.service;

import com.demo.telecom.exception.ResourceNotFoundException;
import com.demo.telecom.model.PhoneNumber;
import com.demo.telecom.repository.PhoneNumberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("OperatorService")
public class OperatorServiceImpl implements OperatorService {

    private final PhoneNumberDao phoneNumberDao;

    @Autowired
    public OperatorServiceImpl(PhoneNumberDao phoneNumberDao) {
        this.phoneNumberDao = phoneNumberDao;
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberDao.findAll();
    }

    @Override
    public List<PhoneNumber> getPhoneNumbers(Long customerId) {
        return phoneNumberDao.findByCustomer_Id(customerId);
    }

    @Override
    public PhoneNumber activatePhoneNumber(Long phoneNumberId) throws ResourceNotFoundException {
        PhoneNumber phoneNumber = phoneNumberDao.findById(phoneNumberId)
                .orElseThrow(() -> new ResourceNotFoundException("Phone number not find."));
        phoneNumber.setActivated(true);
        return phoneNumberDao.save(phoneNumber);
    }
}
