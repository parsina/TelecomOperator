package com.demo.telecom.service;

import com.demo.telecom.exception.ResourceNotFoundException;
import com.demo.telecom.model.Customer;
import com.demo.telecom.model.PhoneNumber;
import com.demo.telecom.repository.PhoneNumberDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OperatorServiceTest {

    @Mock
    private PhoneNumberDao dao;

    private OperatorService service;

    @BeforeEach
    public void setup() {
        this.service = new OperatorServiceImpl(dao);
    }

    @Test
    void testGetAllPhoneNumbers_Successful() {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        Customer customer = new Customer(1L, "First Name 1", "Last Name 1");

        PhoneNumber phoneNumber1 = new PhoneNumber(1L, "111111111", false, customer);
        PhoneNumber phoneNumber2 = new PhoneNumber(2L, "222222222", false, customer);
        PhoneNumber phoneNumber3 = new PhoneNumber(3L, "333333333", false, customer);

        phoneNumbers.add(phoneNumber1);
        phoneNumbers.add(phoneNumber2);
        phoneNumbers.add(phoneNumber3);

        when(dao.findAll()).thenReturn(phoneNumbers);

        List<PhoneNumber> phoneNumberList = service.getAllPhoneNumbers();

        assertNotNull(phoneNumberList);
        assertFalse(phoneNumberList.isEmpty());
        assertEquals(phoneNumberList.size(), 3);
        assertEquals(phoneNumberList.get(0).getId(), 1L);
        assertFalse(phoneNumberList.get(0).isActivated());
        assertEquals(phoneNumberList.get(0).getNumber(), "111111111");
        assertEquals(phoneNumberList.get(0).getCustomer(), customer);
    }

    @Test
    void testGetPhoneNumbers_Successful() {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        Customer customer = new Customer(1L, "First Name 1", "Last Name 1");

        PhoneNumber phoneNumber1 = new PhoneNumber(1L, "111111111", false, customer);
        PhoneNumber phoneNumber2 = new PhoneNumber(2L, "222222222", false, customer);
        PhoneNumber phoneNumber3 = new PhoneNumber(3L, "333333333", false, customer);

        phoneNumbers.add(phoneNumber1);
        phoneNumbers.add(phoneNumber2);
        phoneNumbers.add(phoneNumber3);

        when(dao.findByCustomer_Id(1L)).thenReturn(phoneNumbers);

        List<PhoneNumber> phoneNumberList = service.getPhoneNumbers(1L);

        assertNotNull(phoneNumberList);
        assertFalse(phoneNumberList.isEmpty());
        assertEquals(phoneNumberList.size(), 3);
        assertEquals(phoneNumberList.get(0).getId(), 1L);
        assertFalse(phoneNumberList.get(0).isActivated());
        assertEquals(phoneNumberList.get(0).getNumber(), "111111111");
        assertEquals(phoneNumberList.get(0).getCustomer(), customer);
    }

    @Test
    void testActivatePhoneNumber_Successful() throws ResourceNotFoundException {
        Customer customer = new Customer(1L, "First Name 1", "Last Name 1");
        PhoneNumber phoneNumber1 = new PhoneNumber(1L, "111111111", false, customer);

        when(dao.findById(1L)).thenReturn(Optional.of(phoneNumber1));
        when(dao.save(any())).thenReturn(phoneNumber1);

        PhoneNumber phoneNumber = service.activatePhoneNumber(1L);

        assertNotNull(phoneNumber);
        assertTrue(phoneNumber.isActivated());
    }

    @Test
    void testActivatePhoneNumber_ThrowException() throws ResourceNotFoundException {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            service.activatePhoneNumber(1L);
        });

        String expectedMessage = "Phone number not find.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
