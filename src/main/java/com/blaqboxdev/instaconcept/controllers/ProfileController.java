package com.blaqboxdev.instaconcept.controllers;

import com.blaqboxdev.instaconcept.models.Profile;
import com.blaqboxdev.instaconcept.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    //    Get ALL Profiles
    @GetMapping("/")
    private List<Profile> getAllProfiles(){
        return profileService.getAllProfiles();
    }
}
