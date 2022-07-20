package com.dgs.dgsQuery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private Integer personId;
    private String personName;
    private PersonAddress personAddress;

}
