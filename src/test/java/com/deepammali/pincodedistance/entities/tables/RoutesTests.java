package com.deepammali.pincodedistance.entities.tables;

import com.deepammali.pincodedistance.entities.embedable.Route;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RoutesTests {

    private Routes routes;

    @Mock
    private Origin origin;

    @Mock
    private Destination destination;

    @Test
    public void givenRoutesOriginAndDestination_whenCreated_thenNotNull() {
        routes = new Routes();

        assertNotNull(routes);

        assertNull(routes.getRoutesId());
        assertNull(routes.getRoutes());
        assertNull(routes.getOrigin());
        assertNull(routes.getDestination());

        routes = new Routes(new ArrayList<Route>(), origin, destination);

        assertNotNull(routes);

        assertNull(routes.getRoutesId());

        assertNotNull(routes.getRoutes());

        assertNotNull(routes.getOrigin());
        assertEquals(origin, routes.getOrigin());

        assertNotNull(routes.getDestination());
        assertEquals(destination, routes.getDestination());
    }

}
