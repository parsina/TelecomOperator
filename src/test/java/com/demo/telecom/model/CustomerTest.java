package com.demo.telecom.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {

    @Test
    void testCustomerConstructor() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("First Name");
        customer.setLastName("Last Name");

        Customer customerTest = new Customer(1L, "First Name", "Last Name");

        assertNotNull(customerTest);
        assertEquals(customerTest.getId(), customer.getId());
        assertEquals(customerTest.getFirstName(), customer.getFirstName());
        assertEquals(customerTest.getLastName(), customer.getLastName());
    }

}
