package com.blaqboxdev.instaconcept.exceptions;

public class InvalidPasswordResetTokenException extends Exception{
    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return "Token does not exist or has already expired";
    }
}
