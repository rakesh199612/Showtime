package com.showTime.aiservice.models.api;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateNewUserResponseBody {
    private String firstName;
    private String lastName;
    private String Email;
    private String password;
    private String userType;
    private String location;
    private double phone_no;

}
