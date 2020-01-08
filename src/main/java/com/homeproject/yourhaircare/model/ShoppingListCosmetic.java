package com.homeproject.yourhaircare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@Entity
public class ShoppingListCosmetic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private ShoppingList shoppingList;
    @ManyToOne
    private Cosmetic cosmeticFromShop;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
