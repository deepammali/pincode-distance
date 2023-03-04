package com.deepammali.pincodedistance.entities.requests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ApiRequestBodyTests {

    private ApiRequestBody apiRequestBody;

    @Test
    public void whenCreated_thenCheckNotNull() {

        apiRequestBody = new ApiRequestBody("110001", "400001");

        assertNotNull(apiRequestBody);

        assertNotNull(apiRequestBody.getFrom_pincode());
        assertEquals("110001", apiRequestBody.getFrom_pincode());

        assertNotNull(apiRequestBody.getTo_pincode());
        assertEquals("400001", apiRequestBody.getTo_pincode());

    }

}
