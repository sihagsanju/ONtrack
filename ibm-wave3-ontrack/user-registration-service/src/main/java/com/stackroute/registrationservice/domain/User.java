package com.stackroute.registrationservice.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Registrations")
@Getter
@Setter
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, scope = User.class)
public class User {
    //    @Id
//    @JsonProperty("id")
//    private int id;
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
    @JsonProperty("address")
    private Address address;

    public User(String name, String userId, String password, String mobileNo, String dateofBirth, String gender, Address address) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.mobileNo = mobileNo;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", dateofBirth='" + dateofBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                '}';
    }
}
