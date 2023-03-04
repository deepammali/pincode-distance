package com.deepammali.pincodedistance.controllers;

import com.deepammali.pincodedistance.services.MainService;
import com.deepammali.pincodedistance.entities.requests.ApiRequestBody;

import java.util.List;

import org.json.JSONObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MainController {

        @Autowired
        private MainService mainService;

        @PostMapping("/routes")
        public ResponseEntity<Object> getDistanceDurationAndRoutes(
                        @RequestBody @Validated ApiRequestBody apiRequestBody) {

                if (!apiRequestBody.getFrom_pincode().matches("\\d{6}")
                                || !apiRequestBody.getTo_pincode().matches("\\d{6}")) {
                        return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);
                }

                List<Double> origin = mainService.getOriginLatLon(apiRequestBody.getFrom_pincode());
                List<Double> destination = mainService.getDestinationLatLon(apiRequestBody.getTo_pincode());

                JSONObject jsonRequestBodyGC = mainService.getJsonRequestBody(origin.get(0), origin.get(1),
                                destination.get(0),
                                destination.get(1));

                return new ResponseEntity<>(
                                mainService.getListofRoutes(jsonRequestBodyGC, apiRequestBody.getFrom_pincode(),
                                                apiRequestBody.getTo_pincode()),
                                HttpStatus.OK);
        }

}
