package com.deepammali.pincodedistance.services;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.deepammali.pincodedistance.entities.requests.ApiRequestBody;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PincodeToLatLongServiceTests {

    private ApiRequestBody requestBody;

    @Autowired
    private PincodeToLatLonService pincodeToLatLonService;

    @BeforeAll
    public void init() {
        requestBody = new ApiRequestBody("440016", "424001");
    }

    @Test
    public void givenRequest_whenPincodeToLatLonService_thenReturnResponse() {

        List<Double> fromPinLatLon = pincodeToLatLonService.getResponse(requestBody.getFrom_pincode());
        assertNotNull(fromPinLatLon.get(0));
        assertNotNull(fromPinLatLon.get(1));

        List<Double> toPinLatLon = pincodeToLatLonService.getResponse(requestBody.getTo_pincode());
        assertNotNull(toPinLatLon.get(0));
        assertNotNull(toPinLatLon.get(1));
    }

}
