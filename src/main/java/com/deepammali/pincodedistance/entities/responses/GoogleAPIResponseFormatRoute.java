package com.deepammali.pincodedistance.entities.responses;

import java.util.List;

import com.deepammali.pincodedistance.entities.embedable.Polyline;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GoogleAPIResponseFormatRoute {

    private Long distanceMeters;

    private String duration;

    private Polyline polyline;

    private List<String> routeLabels;

}
