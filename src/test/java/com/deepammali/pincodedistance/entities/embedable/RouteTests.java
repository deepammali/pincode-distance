package com.deepammali.pincodedistance.entities.embedable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class RouteTests {

    private Route route;

    @Test
    public void givenDistanceDurationEncodedPolylineAndRouteLabels_whenCreated_thenNotNull() {
        route = new Route(1L, "1s", "dlfhohasjdnfaskdfu", new ArrayList<>());

        assertNotNull(route);

        assertNotNull(route.getDistanceMeters());
        assertEquals(1L, route.getDistanceMeters());

        assertNotNull(route.getDuration());
        assertEquals("1s", route.getDuration());

        assertNotNull(route.getEncodedPolyline());
        assertEquals("dlfhohasjdnfaskdfu", route.getEncodedPolyline());

        assertNotNull(route.getRouteLabels());
    }

}
