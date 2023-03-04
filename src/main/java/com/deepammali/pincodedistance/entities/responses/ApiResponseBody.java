package com.deepammali.pincodedistance.entities.responses;

import java.util.List;

import com.deepammali.pincodedistance.entities.embedable.Route;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseBody {

    private List<Route> routes;

}
