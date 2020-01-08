package com.homeproject.yourhaircare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Cosmetic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
    private Type type;
    @ManyToOne(fetch = FetchType.LAZY)
    private Feature feature;
    private String name;
    private Boolean preservative;
    private OffsetDateTime addedAt;
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "cosmetic")
    private List<SiliconCosmetic> siliconsInCosmetic;
    @OneToMany(mappedBy = "cosmeticUser")
    private List<UserCosmetic> assignedUsers;
    @OneToMany(mappedBy = "cosmeticFromShop")
    private List<ShoppingListCosmetic> assignedShoppingLists;
}
