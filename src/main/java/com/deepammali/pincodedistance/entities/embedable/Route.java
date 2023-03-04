package com.deepammali.pincodedistance.entities.embedable;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Nonnull
    private Long distanceMeters;

    @Nonnull
    private String duration;

    @Nonnull
    @Column(columnDefinition = "TEXT")
    private String encodedPolyline;

    @Nonnull
    private List<String> routeLabels;

}
