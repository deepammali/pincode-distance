package com.deepammali.pincodedistance.entities.tables;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OriginTests {

    private Origin origin;

    @Test
    public void whenCreated_thenNotNull() {
        origin = new Origin();

        assertNotNull(origin);

        assertNull(origin.getLatitude());
        assertNull(origin.getLongitude());
        assertNull(origin.getOriginId());
        assertNull(origin.getPincode());

        origin = new Origin("110001", 28.644800, 77.216721);

        assertNotNull(origin);

        assertNull(origin.getOriginId());

        assertNotNull(origin.getPincode());
        assertEquals("110001", origin.getPincode());

        assertNotNull(origin.getLatitude());
        assertEquals(28.644800, origin.getLatitude());

        assertNotNull(origin.getLongitude());
        assertEquals(77.216721, origin.getLongitude());

    }

}
