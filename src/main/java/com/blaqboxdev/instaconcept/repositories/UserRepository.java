package com.blaqboxdev.instaconcept.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blaqboxdev.instaconcept.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);
}
