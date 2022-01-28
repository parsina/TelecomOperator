package com.demo.telecom.exception;

import com.demo.telecom.controller.OperatorController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {

    @Mock
    private WebRequest webRequest;

    GlobalExceptionHandler handler;

    @BeforeEach
    void setup() {
        this.handler = new GlobalExceptionHandler();
    }

    @Test
    void testResourceNotFoundException() {
        ResourceNotFoundException exception = new ResourceNotFoundException("");

        ResponseEntity<?> response = this.handler.resourceNotFoundException(exception, webRequest);

        assertNotNull(response);
        assertEquals(response.getStatusCodeValue(), 404);

    }
}
