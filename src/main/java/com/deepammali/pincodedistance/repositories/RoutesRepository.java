package com.deepammali.pincodedistance.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepammali.pincodedistance.entities.tables.Destination;
import com.deepammali.pincodedistance.entities.tables.Origin;
import com.deepammali.pincodedistance.entities.tables.Routes;

public interface RoutesRepository extends JpaRepository<Routes, Long> {

    public Optional<Routes> findByOriginAndDestination(Origin origin, Destination destination);

}
