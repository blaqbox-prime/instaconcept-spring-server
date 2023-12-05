package com.blaqboxdev.instaconcept.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity(name = "passwordresettoken")
@Table(name = "passwordresettoken")
public class PasswordResetToken {

    @Id
    private UUID token_id;

    @Column(nullable = false)
    LocalDateTime expiration = LocalDateTime.now().plusHours(16);

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id", nullable=false, updatable=false)
    User user;
}
