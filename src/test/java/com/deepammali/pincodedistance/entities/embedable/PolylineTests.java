package com.deepammali.pincodedistance.entities.embedable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class PolylineTests {

    private Polyline polyline;

    @Test
    public void givenString_whenCreated_thenCheckCreated() {
        String test = "This is a test string for polyline: abcdefghjiklmnopqrstuvwxyz1234567890!@#$%^&*()_+{}:\"<>?[];',./";
        
        polyline = new Polyline(test);

        assertNotNull(polyline);
        assertNotNull(polyline.getEncodedPolyline());
        assertEquals(test, polyline.getEncodedPolyline());
    }

    @Test
    public void givenNoString_whenCreated_thenCheckCreated() {
        String test = "This is a test string for polyline: abcdefghjiklmnopqrstuvwxyz1234567890!@#$%^&*()_+{}:\"<>?[];',./";
        
        polyline = new Polyline();

        assertNotNull(polyline);
        assertNull(polyline.getEncodedPolyline());

        polyline.setEncodedPolyline(test);

        assertNotNull(polyline.getEncodedPolyline());
        assertEquals(test, polyline.getEncodedPolyline());
    }

}
