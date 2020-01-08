package com.homeproject.yourhaircare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DailyUserCare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userCare;
    private Date dateCare;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cosmetic underOil;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cosmetic oiling;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cosmetic firstO;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cosmetic washing;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cosmetic secondO;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cosmetic lastCosmetic;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cosmetic styling;
    private String description;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
