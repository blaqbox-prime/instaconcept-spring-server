package com.blaqboxdev.instaconcept.exceptions;

public class UserNotFoundException extends Exception {
    @Override
    public String getMessage(){
        return "User email not found.";
    }
}
