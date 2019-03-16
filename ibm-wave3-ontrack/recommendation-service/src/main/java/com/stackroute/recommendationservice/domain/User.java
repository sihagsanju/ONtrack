package com.stackroute.recommendationservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
public class User {

    @Id
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;
    @JsonProperty("mobileNo")
    private String mobileNo;
    @JsonProperty("dateofBirth")
    private String dateofBirth;
    @JsonProperty("gender")
    private String gender;


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", dateofBirth='" + dateofBirth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}