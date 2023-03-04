package com.deepammali.pincodedistance.entities.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiRequestBody {

    private String from_pincode;

    private String to_pincode;

}
