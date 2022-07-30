package com.showTime.aiservice.models.db;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
public class Userdata {
    private String U_id;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String userType;
    private String location;
    private double phone_no;
}
