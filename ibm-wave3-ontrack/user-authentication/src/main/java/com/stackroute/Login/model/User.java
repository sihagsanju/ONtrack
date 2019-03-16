package com.stackroute.Login.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, scope = User.class)
public class User
{


    @Id
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("password")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
