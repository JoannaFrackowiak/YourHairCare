package com.homeproject.yourhaircare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Entity
public class SiliconCosmetic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Cosmetic cosmetic;
    @ManyToOne
    private Silicon silicon;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
