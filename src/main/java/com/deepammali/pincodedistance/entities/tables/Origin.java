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
@Table(name = "origin_location")
public class Origin {

    @Id
    @GeneratedValue
    private Long originId;

    private String pincode;

    private Double latitude;

    private Double longitude;

    @OneToMany(mappedBy = "origin")
    private Set<Routes> routes;

    public Origin(String pincode, Double latitude, Double longitude) {
        this.pincode = pincode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    

}
