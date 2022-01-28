package com.demo.telecom.controller;

import com.demo.telecom.exception.ResourceNotFoundException;
import com.demo.telecom.model.Customer;
import com.demo.telecom.model.PhoneNumber;
import com.demo.telecom.service.OperatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OperatorControllerTest {

    @Mock
    private OperatorService service;

    private OperatorController controller;

    @BeforeEach
    void setup() {
        this.controller = new OperatorController(service);
    }


    @Test
    void testGetAllPhoneNumbers_whenCalled_thenReturn() {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        Customer customer = new Customer(1L, "First Name 1", "Last Name 1");

        PhoneNumber phoneNumber1 = new PhoneNumber(1L, "111111111", false, customer);
        PhoneNumber phoneNumber2 = new PhoneNumber(2L, "222222222", false, customer);
        PhoneNumber phoneNumber3 = new PhoneNumber(3L, "333333333", false, customer);

        phoneNumbers.add(phoneNumber1);
        phoneNumbers.add(phoneNumber2);
        phoneNumbers.add(phoneNumber3);

        when(service.getAllPhoneNumbers()).thenReturn(phoneNumbers);

        List<PhoneNumber> phoneNumberList = controller.getAllPhoneNumbers();

        assertNotNull(phoneNumberList);
        assertFalse(phoneNumberList.isEmpty());
        assertEquals(phoneNumberList.size(), 3);
        assertEquals(phoneNumberList.get(0).getId(), 1L);
        assertFalse(phoneNumberList.get(0).isActivated());
        assertEquals(phoneNumberList.get(0).getNumber(), "111111111");
        assertEquals(phoneNumberList.get(0).getCustomer(), customer);
    }

    @Test
    void testGetPhoneNumbersByCustomer_whenCalled_thenReturn() throws ResourceNotFoundException {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        Customer customer = new Customer(1L, "First Name 1", "Last Name 1");

        PhoneNumber phoneNumber1 = new PhoneNumber(1L, "111111111", false, customer);
        PhoneNumber phoneNumber2 = new PhoneNumber(2L, "222222222", false, customer);
        PhoneNumber phoneNumber3 = new PhoneNumber(3L, "333333333", false, customer);

        phoneNumbers.add(phoneNumber1);
        phoneNumbers.add(phoneNumber2);
        phoneNumbers.add(phoneNumber3);

        when(service.getPhoneNumbers(1L)).thenReturn(phoneNumbers);

        List<PhoneNumber> phoneNumberList = controller.getPhoneNumbersByCustomer(1L);

        assertNotNull(phoneNumberList);
        assertFalse(phoneNumberList.isEmpty());
        assertEquals(phoneNumberList.size(), 3);
        assertEquals(phoneNumberList.get(0).getId(), 1L);
        assertFalse(phoneNumberList.get(0).isActivated());
        assertEquals(phoneNumberList.get(0).getNumber(), "111111111");
        assertEquals(phoneNumberList.get(0).getCustomer(), customer);
    }

    @Test
    void testActivatePhoneNumber_whenCalled_thenReturn() throws ResourceNotFoundException {
        Customer customer = new Customer(1L, "First Name 1", "Last Name 1");

        PhoneNumber phoneNumber1 = new PhoneNumber(1L, "111111111", true, customer);

        when(service.activatePhoneNumber(1L)).thenReturn(phoneNumber1);

        PhoneNumber phoneNumber = controller.activatePhoneNumber(1L);

        assertNotNull(phoneNumber);
        assertTrue(phoneNumber.isActivated());
    }
}
