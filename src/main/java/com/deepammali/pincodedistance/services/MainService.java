package com.deepammali.pincodedistance.services;

import com.deepammali.pincodedistance.entities.tables.Origin;
import com.deepammali.pincodedistance.entities.tables.Routes;
import com.deepammali.pincodedistance.entities.embedable.Route;
import com.deepammali.pincodedistance.entities.tables.Destination;
import com.deepammali.pincodedistance.repositories.OriginRepository;
import com.deepammali.pincodedistance.repositories.RoutesRepository;
import com.deepammali.pincodedistance.entities.responses.ApiResponseBody;
import com.deepammali.pincodedistance.repositories.DestinationRepository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MainService {

    @Autowired
    private PincodeToLatLonService pincodeToLatLonService;

    @Autowired
    private OriginRepository originRepository;

    @Autowired
    private LatLonToRouteService latLonToRouteService;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private RoutesRepository routesRepository;

    public List<Double> getOriginLatLon(String originPincode) {

        Optional<Origin> origin = originRepository.findByPincode(originPincode);

        List<Double> coordinates;

        if (!origin.isPresent()) {
            coordinates = pincodeToLatLonService.getResponse(originPincode);
            originRepository.save(new Origin(originPincode, coordinates.get(0), coordinates.get(1)));
            return coordinates;
        }

        coordinates = new ArrayList<>();
        coordinates.add(origin.get().getLatitude());
        coordinates.add(origin.get().getLongitude());
        return coordinates;
    }

    public List<Double> getDestinationLatLon(String destinationPincode) {

        Optional<Destination> destination = destinationRepository.findByPincode(destinationPincode);

        List<Double> coordinates;

        if (!destination.isPresent()) {
            coordinates = pincodeToLatLonService.getResponse(destinationPincode);
            destinationRepository.save(new Destination(destinationPincode, coordinates.get(0), coordinates.get(1)));
            return coordinates;
        }

        coordinates = new ArrayList<>();
        coordinates.add(destination.get().getLatitude());
        coordinates.add(destination.get().getLongitude());
        return coordinates;
    }

    public JSONObject getJsonRequestBody(Double originLat, Double originLon, Double destinationLat,
            Double destinationLon) {

        JSONObject requestBody = new JSONObject();

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
        return requestBody;
    }

    public ApiResponseBody getListofRoutes(JSONObject jsonRequestBodyGC, String originPincode,
            String destinationPincode) {

        Optional<Routes> routes = routesRepository.findByOriginAndDestination(
                originRepository.findByPincode(originPincode).get(),
                destinationRepository.findByPincode(destinationPincode).get());

        if (!routes.isPresent()) {
            List<Route> response = latLonToRouteService.getResponse(jsonRequestBodyGC);
            routesRepository.save(new Routes(response, originRepository.findByPincode(originPincode).get(),
                    destinationRepository.findByPincode(destinationPincode).get()));
            return new ApiResponseBody(response);
        }

        return new ApiResponseBody(routes.get().getRoutes());
    }

}
