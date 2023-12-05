package com.blaqboxdev.instaconcept.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blaqboxdev.instaconcept.exceptions.InvalidPasswordResetTokenException;
import com.blaqboxdev.instaconcept.models.PasswordResetToken;
import com.blaqboxdev.instaconcept.models.ResetPasswordRequest;
import com.blaqboxdev.instaconcept.models.User;
import com.blaqboxdev.instaconcept.repositories.PasswordResetTokenRepository;
import com.blaqboxdev.instaconcept.repositories.UserRepository;

@Service
public class PasswordResetService {
    
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final UserRepository userRepository;


    @Autowired
    public PasswordResetService(PasswordResetTokenRepository passResetTokenRepo, UserRepository userRepo){
        passwordResetTokenRepository = passResetTokenRepo;
        userRepository = userRepo;
    }


    @Transactional
    public PasswordResetToken generatePasswordResetToken(String userEmail){
        User user = userRepository.findByEmail(userEmail);

        if(user != null){
            // Generate new Pass Reset Token
            PasswordResetToken resetToken = new PasswordResetToken();
            resetToken.setUser(user);
            UUID token_id = UUID.randomUUID();
            resetToken.setToken_id(token_id);
            
            // Save to DB
            passwordResetTokenRepository.save(resetToken);
            // Send Token to user
             
            // Return the saved token
            return passwordResetTokenRepository.findById(token_id).orElse(null);
        }
        return null;
    }

    public User resetPassword(ResetPasswordRequest resetPasswordRequest, String token_id) throws InvalidPasswordResetTokenException {
        PasswordResetToken token = passwordResetTokenRepository.findById(UUID.fromString(token_id)).orElse(null);
        
        System.out.println(token);
        System.out.println(resetPasswordRequest);
        
        if(token == null || !validateToken(resetPasswordRequest.getEmail(),token)) {
            throw new InvalidPasswordResetTokenException();
        } else {
            User user = token.getUser();
            user.setPassword(resetPasswordRequest.getNewPassword());
            userRepository.save(user);
            return user;
        }
    }


    private boolean validateToken(String email,PasswordResetToken token) {
        if (email.isEmpty() || token == null) return false;

        return email.equals(token.getUser().getEmail()) && token.getExpiration().isAfter(LocalDateTime.now());
    }   
}
