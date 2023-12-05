package com.blaqboxdev.instaconcept.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserLoginRequest {

    private String email;
    private String password;

    public UserLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
