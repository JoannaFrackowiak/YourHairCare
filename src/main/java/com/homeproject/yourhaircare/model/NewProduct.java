package com.homeproject.yourhaircare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class NewProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userAddProduct;
    private String brand;
    private String type;
    private String feature;
    private String name;
    private Boolean silicon;
    private Boolean preservative;
    private String additionalInfo;
    private OffsetDateTime addedAt;
    private OffsetDateTime updatedAt;
}
