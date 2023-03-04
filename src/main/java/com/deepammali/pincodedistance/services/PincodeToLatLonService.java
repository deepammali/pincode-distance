package com.deepammali.pincodedistance.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

@Service
public class PincodeToLatLonService {

    @Value("${pincode.distance.gc_maps_api_key}")
    private String GC_MAPS_API_KEY;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Double> getResponse(String pincode) {

        List<Double> coordinates = new ArrayList<>();
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + pincode + "&key=" + GC_MAPS_API_KEY;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        String jsonResponseString = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class).getBody();
        JSONObject jsonObject = new JSONObject(jsonResponseString).getJSONArray("results").getJSONObject(0)
                .getJSONObject("geometry").getJSONObject("location");
        coordinates.add(jsonObject.getDouble("lat"));
        coordinates.add(jsonObject.getDouble("lng"));
        return coordinates;
    }
}
