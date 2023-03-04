package com.deepammali.pincodedistance.entities.tables;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DestinationTests {

    private Destination destination;

    @Test
    public void whenCreated_thenNotNull() {
        destination = new Destination();

        assertNotNull(destination);

        assertNull(destination.getLatitude());
        assertNull(destination.getLongitude());
        assertNull(destination.getDestinationId());
        assertNull(destination.getPincode());

        destination = new Destination("110001", 28.644800, 77.216721);

        assertNotNull(destination);

        assertNull(destination.getDestinationId());

        assertNotNull(destination.getPincode());
        assertEquals("110001", destination.getPincode());

        assertNotNull(destination.getLatitude());
        assertEquals(28.644800, destination.getLatitude());

        assertNotNull(destination.getLongitude());
        assertEquals(77.216721, destination.getLongitude());

    }

}
