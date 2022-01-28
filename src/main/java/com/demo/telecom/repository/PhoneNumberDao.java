package com.demo.telecom.repository;

import com.demo.telecom.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberDao extends JpaRepository<PhoneNumber, Long> {
    List<PhoneNumber> findByCustomer_Id(Long customerId);
}
