package com.blaqboxdev.instaconcept.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID profile_id;
    private String username;
    private String name;
    private String email;
    private String gender;
    private String bio;
    private String website;
    private String image;
    private boolean verified;
    private String password;
    private LocalDateTime date_created;
    private LocalDateTime last_updated;
}
