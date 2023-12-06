package com.blaqboxdev.instaconcept.exceptions;

public class UsernameAlreadyTakenException extends Exception {
    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return "The username has already been taken.";
    }
}
