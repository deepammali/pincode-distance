package com.deepammali.pincodedistance.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.json.JSONObject;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.deepammali.pincodedistance.services.MainService;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTests {

    @Autowired
    private MockMvc mvc;

    @Mock
    private MainService mainService;

    @InjectMocks
    private MainController mainControllerUnderTest;

    @Test
    public void testRouteEndpoint() throws Exception {

        String jsonBody = new JSONObject().put("from_pincode", "141106").put("to_pincode", "110060").toString();

        mvc.perform(post("/routes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
