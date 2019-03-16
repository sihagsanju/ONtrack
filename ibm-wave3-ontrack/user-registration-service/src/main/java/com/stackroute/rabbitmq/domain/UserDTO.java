package com.stackroute.rabbitmq.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
@Data
@Builder
public class UserDTO {
    @Id
    @JsonProperty("id")
    private int id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", dateofBirth='" + dateofBirth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

