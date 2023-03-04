package com.deepammali.pincodedistance.entities.tables;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "destination_location")
public class Destination {

    @Id
    @GeneratedValue
    private Long destinationId;

    private String pincode;

    private Double latitude;

    private Double longitude;

    @OneToMany(mappedBy = "destination")
    private Set<Routes> routes;

    public Destination(String pincode, Double latitude, Double longitude) {
        this.pincode = pincode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
