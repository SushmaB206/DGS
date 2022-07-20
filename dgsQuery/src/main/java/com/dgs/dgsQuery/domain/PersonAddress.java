package com.dgs.dgsQuery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonAddress {

    private String streetName;
    private String houseNumber;
    private String city;
    private String country;
}
