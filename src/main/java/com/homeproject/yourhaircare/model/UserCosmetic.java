package com.homeproject.yourhaircare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class UserCosmetic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User userCosmetic;
    @ManyToOne
    private Cosmetic cosmeticUser;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
