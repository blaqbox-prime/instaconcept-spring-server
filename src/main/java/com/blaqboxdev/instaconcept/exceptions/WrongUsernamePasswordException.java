package com.blaqboxdev.instaconcept.exceptions;

public class WrongUsernamePasswordException extends Exception{
    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return "Incorrect username or password.";
    }
}
