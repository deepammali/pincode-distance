package com.deepammali.pincodedistance.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepammali.pincodedistance.entities.tables.Origin;

public interface OriginRepository extends JpaRepository<Origin, Long> {

    public Optional<Origin> findByPincode(String from_pincode);

}
