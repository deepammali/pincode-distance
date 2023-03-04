package com.deepammali.pincodedistance.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepammali.pincodedistance.entities.tables.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

    public Optional<Destination> findByPincode(String pincode);

}