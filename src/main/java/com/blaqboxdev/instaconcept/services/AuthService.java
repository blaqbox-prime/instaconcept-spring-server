package com.blaqboxdev.instaconcept.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blaqboxdev.instaconcept.exceptions.UserNotFoundException;
import com.blaqboxdev.instaconcept.exceptions.WrongUsernamePasswordException;
import com.blaqboxdev.instaconcept.models.PasswordResetToken;
import com.blaqboxdev.instaconcept.models.User;
import com.blaqboxdev.instaconcept.models.UserLoginRequest;
import com.blaqboxdev.instaconcept.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User loginUser(UserLoginRequest loginRequest) throws UserNotFoundException, WrongUsernamePasswordException{
        User user = userRepository.findByEmail(loginRequest.getEmail());
        // Throw Error If not found
        if (user == null) throw new UserNotFoundException();
        // Throw Error if Password doesn't Match
        if (user != null && !user.getPassword().equals(loginRequest.getPassword())) throw new WrongUsernamePasswordException();
        
        return user;
    }
    
   
    

}
