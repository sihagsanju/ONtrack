package com.stackroute.registrationservice.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, scope = Message.class)

public class Message {

    @JsonProperty("userId")
    private String userId;
    @JsonProperty("password")
    private  String password;

    @Override
    public String toString() {
        return "Msg{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
