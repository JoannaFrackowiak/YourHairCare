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
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userShopList;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "shoppingList")
    private List<ShoppingListCosmetic> cosmeticsFromShop;


}
