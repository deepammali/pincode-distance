package com.deepammali.pincodedistance.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import com.deepammali.pincodedistance.entities.responses.GoogleMapsAPIResponse;
import com.deepammali.pincodedistance.entities.responses.GoogleAPIResponseFormatRoute;

import com.deepammali.pincodedistance.entities.embedable.Route;

@Service
public class LatLonToRouteService {

    @Value("${pincode.distance.gc_maps_api_key}")
    private String GC_MAPS_API_KEY;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Route> getResponse(JSONObject requestBody) {

        String url = "https://routes.googleapis.com/directions/v2:computeRoutes";

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-Goog-Api-Key", this.GC_MAPS_API_KEY);
        httpHeaders.set("X-Goog-FieldMask",
                "routes.distanceMeters,routes.duration,routes.polyline.encodedPolyline,routes.routeLabels");

        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody.toString(), httpHeaders);

        GoogleMapsAPIResponse distanceAndDuration = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
                GoogleMapsAPIResponse.class).getBody();

        return convertFromGoogleAPIResponseFormatToRoutes(distanceAndDuration);
    }

    private List<Route> convertFromGoogleAPIResponseFormatToRoutes(GoogleMapsAPIResponse convertFrom) {
        List<GoogleAPIResponseFormatRoute> googleFormatRoutes = convertFrom.getRoutes();
        List<Route> routes = new ArrayList<>();

        for (int i = 0; i < googleFormatRoutes.size(); i++) {
            routes.add(new Route(
                    googleFormatRoutes.get(i).getDistanceMeters(),
                    googleFormatRoutes.get(i).getDuration(),
                    googleFormatRoutes.get(i).getPolyline().getEncodedPolyline(),
                    googleFormatRoutes.get(i).getRouteLabels()));
        }
        return routes;
    }

}
