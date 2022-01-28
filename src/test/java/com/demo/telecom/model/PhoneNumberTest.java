package com.demo.telecom.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PhoneNumberTest {

    @Test
    void testCustomerConstructor() {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setId(1L);
        phoneNumber.setNumber("111111111");
        phoneNumber.setActivated(false);
        phoneNumber.setCustomer(null);

        PhoneNumber phoneNumberTest = new PhoneNumber(1L, "111111111", false, null);

        assertNotNull(phoneNumberTest);
        assertEquals(phoneNumberTest.getId(), phoneNumber.getId());
        assertEquals(phoneNumberTest.getCustomer(), phoneNumber.getCustomer());
        assertEquals(phoneNumberTest.getNumber(), phoneNumber.getNumber());
        assertEquals(phoneNumberTest.isActivated(), phoneNumber.isActivated());
    }
}
