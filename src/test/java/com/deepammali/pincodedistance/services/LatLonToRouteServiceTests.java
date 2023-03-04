package com.deepammali.pincodedistance.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.deepammali.pincodedistance.entities.embedable.Route;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LatLonToRouteServiceTests {

        @Autowired
        private LatLonToRouteService latLonToRouteService;

        JSONObject requestBody = new JSONObject();

        @BeforeAll
        public void init() {

                // DELHI
                Double originLat = 28.644800;
                Double originLon = 77.216721;

                // MUMBAI
                Double destinationLat = 19.076090;
                Double destinationLon = 72.877426;

                requestBody.put("origin", new JSONObject().put("location",
                                new JSONObject().put("latLng",
                                                new JSONObject().put("latitude", originLat).put("longitude",
                                                                originLon))));

                requestBody.put("destination", new JSONObject().put("location",
                                new JSONObject().put("latLng",
                                                new JSONObject().put("latitude", destinationLat).put("longitude",
                                                                destinationLon))));

                requestBody.put("travelMode", "DRIVE");
                requestBody.put("computeAlternativeRoutes", true);
                requestBody.put("languageCode", "en-IN");
                requestBody.put("units", "METRIC");

        }

        @Test
        public void givenLatLon_whenLatLonToRouteService_thenReturnResponse() {

                List<Route> routeResponse = latLonToRouteService.getResponse(requestBody);

                assertNotNull(routeResponse);
                assertFalse(routeResponse.isEmpty());
                assertNotNull(routeResponse.get(0));
        }

}
