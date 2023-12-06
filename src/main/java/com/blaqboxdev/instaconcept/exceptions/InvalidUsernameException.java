package com.blaqboxdev.instaconcept.exceptions;

public class InvalidUsernameException extends Exception{
    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return "username is invalid. Usernames must be in lowercase, can only include numbers and underscore";
    }
}
