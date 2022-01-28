package com.demo.telecom.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ErrorDetailsTest {

    private ErrorDetails details;

    @BeforeEach
    public void setup() {
        this.details = new ErrorDetails(null, "Test message", "Test details");
    }

    @Test
    void testClassMethods() {
        assertNull(this.details.getTimestamp());
        assertNotNull(details.getDetails());
        assertNotNull(details.getMessage());
        assertEquals(details.getMessage(), "Test message");
        assertEquals(details.getDetails(), "Test details");
    }
}
