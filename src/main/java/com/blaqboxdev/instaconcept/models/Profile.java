package com.blaqboxdev.instaconcept.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    
    @Id
    private UUID profile_id;

    @Column(nullable = false)
    private String username;

    private String bio;

    private String display_email;

    @Column(nullable = false)
    private String gender;

    private String avatar;

    @Column(nullable = false)
    private String type;

    private boolean verified = false;

    private LocalDateTime date_created = LocalDateTime.now();

    private LocalDateTime last_update;

    @ManyToOne
    private User user;
}
