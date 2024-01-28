package com.blaqboxdev.instaconcept.repositories;

import com.blaqboxdev.instaconcept.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfilesRepository extends JpaRepository<Profile, UUID> {
}
