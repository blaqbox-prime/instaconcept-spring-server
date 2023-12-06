package com.blaqboxdev.instaconcept.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blaqboxdev.instaconcept.exceptions.InvalidPasswordResetTokenException;
import com.blaqboxdev.instaconcept.exceptions.UserAlreadyExistsException;
import com.blaqboxdev.instaconcept.exceptions.UserNotFoundException;
import com.blaqboxdev.instaconcept.exceptions.WrongUsernamePasswordException;
import com.blaqboxdev.instaconcept.models.ErrorResponse;
import com.blaqboxdev.instaconcept.models.PasswordResetToken;
import com.blaqboxdev.instaconcept.models.ResetPasswordRequest;
import com.blaqboxdev.instaconcept.models.User;
import com.blaqboxdev.instaconcept.models.UserLoginRequest;
import com.blaqboxdev.instaconcept.models.UserRegistrationRequest;
import com.blaqboxdev.instaconcept.repositories.UserRepository;
import com.blaqboxdev.instaconcept.services.AuthService;
import com.blaqboxdev.instaconcept.services.PasswordResetService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    
    @Autowired
    private PasswordResetService passwordResetService;
    
    @PostMapping("/login")
    ResponseEntity<Object> login(@RequestBody UserLoginRequest loginRequest) {
        System.out.println(loginRequest);
        try {
            return ResponseEntity.ok(authService.loginUser(loginRequest));
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (WrongUsernamePasswordException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    
     @GetMapping(path = "/request-password-reset", params = "email")
    public PasswordResetToken getMethodName(@RequestParam String email) {
        return passwordResetService.generatePasswordResetToken(email);
    }


    @PostMapping(path="/reset-password",params = "token")
    public ResponseEntity<Object> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest, @RequestParam String token) {

        try {
            User user = passwordResetService.resetPassword(resetPasswordRequest, token);
            return ResponseEntity.ok().body(user);
        } catch (InvalidPasswordResetTokenException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    // Register a User <<Does not create a profile>>
    @PostMapping("/register")
    public ResponseEntity<Object> registerNewUser(@RequestBody UserRegistrationRequest userDetails) {
        Map<String,Object> data = new HashMap<>();
        User user = null;

        try {
            user = authService.registerUser(userDetails);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
        
        data.put("user_id", user.getUser_id());
        return ResponseEntity.ok(data);
    }
        
}
