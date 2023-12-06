package com.blaqboxdev.instaconcept.exceptions;

public class UserAlreadyExistsException extends Exception{
    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return "Email already registered with a user. Try another email address";
    }
}
