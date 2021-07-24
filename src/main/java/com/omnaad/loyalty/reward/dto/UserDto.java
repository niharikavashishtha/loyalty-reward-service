package com.omnaad.loyalty.reward.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {
    private String firstName;
    private String lastName;
    private Date dob;
    private String mobileNumber;
    private String membershipId;
}
