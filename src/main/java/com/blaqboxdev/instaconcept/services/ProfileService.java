package com.blaqboxdev.instaconcept.services;

import com.blaqboxdev.instaconcept.models.Profile;
import com.blaqboxdev.instaconcept.repositories.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfilesRepository profilesRepository;

    public List<Profile> getAllProfiles() {
        List<Profile> profiles = profilesRepository.findAll();
        return profiles;
    }
}
