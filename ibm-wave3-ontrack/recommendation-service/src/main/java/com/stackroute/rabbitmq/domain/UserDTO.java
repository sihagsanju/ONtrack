package com.stackroute.rabbitmq.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
//    @JsonProperty("id")
//    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("userId")
    private String userId;

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
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", dateofBirth='" + dateofBirth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
