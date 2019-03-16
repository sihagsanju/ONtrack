package com.stackroute.registrationservice.domain;

import lombok.*;

import org.springframework.stereotype.Service;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address
{
    private String addressDetails;
    private String city;
    private String state;
    private String country;


    @Override
    public String toString() {
        return "Address{" +
                "addressDetails='" + addressDetails + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
