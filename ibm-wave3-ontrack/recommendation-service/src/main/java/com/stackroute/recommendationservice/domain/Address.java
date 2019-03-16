package com.stackroute.recommendationservice.domain;

import lombok.*;

@Data
@AllArgsConstructor
public class Address {
    private String addressDetails;
    private String city;
    private String state;
    private String country;
}