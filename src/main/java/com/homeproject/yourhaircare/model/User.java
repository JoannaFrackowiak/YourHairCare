package com.homeproject.yourhaircare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "userShopList")
    private List<ShoppingList> userShoppingList;
    @OneToMany(mappedBy = "userCosmetic")
    @Builder.Default
    private List<UserCosmetic> cosmeticsOfUser = new ArrayList<>();
    @OneToMany(mappedBy = "userAddProduct")
    private List<NewProduct> newProductsLists;
    @OneToMany(mappedBy = "userCare")
    private List<DailyUserCare> dailyUserCareList;
}
