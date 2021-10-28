package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.model.*;
import com.homeproject.yourhaircare.repository.CosmeticRepository;
import com.homeproject.yourhaircare.repository.ShoppingListCosmeticRepository;
import com.homeproject.yourhaircare.repository.ShoppingListRepository;
import com.homeproject.yourhaircare.repository.UserRepository;
import com.homeproject.yourhaircare.service.dto.ShoppingListCosmeticDto;
import com.homeproject.yourhaircare.service.exception.AlreadyExists;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import com.homeproject.yourhaircare.service.exception.NotFound;
import com.homeproject.yourhaircare.service.mapper.ShoppingListCosmeticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@Service
public class ShoppingListCosmeticService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CosmeticRepository cosmeticRepository;
    @Autowired
    private ShoppingListCosmeticRepository shoppingListCosmeticRepository;
    @Autowired
    private ShoppingListRepository shoppingListRepository;
    @Autowired
    private ShoppingListCosmeticMapper shoppingListCosmeticMapper;

    @Transactional
    public ShoppingListCosmeticDto addCosmeticToShoppingList(Long id, String loggedUserEmail) throws BadRequest, AlreadyExists {
        if (id == null || loggedUserEmail == null) {
            throw new BadRequest();
        }
        ShoppingList shoppingList = shoppingListRepository.findByUserShopListEmail(loggedUserEmail);
        ShoppingListCosmetic existShoppingListCosmetic = shoppingListCosmeticRepository.findByCosmeticFromShopIdAndShoppingListId(id, shoppingList.getId());
        if (existShoppingListCosmetic == null) {
            Cosmetic cosmetic = cosmeticRepository.findCosmeticById(id);
            ShoppingListCosmetic shoppingListCosmetic = ShoppingListCosmetic.builder()
                    .shoppingList(shoppingList)
                    .cosmeticFromShop(cosmetic)
                    .createdAt(OffsetDateTime.now())
                    .build();
//            existUserCosmetic = userCosmeticRepository.save(userCosmeticMapper.fromDto());
            ShoppingListCosmetic cosmeticOnList = shoppingListCosmeticRepository.save(shoppingListCosmetic);
            return shoppingListCosmeticMapper.toDto(cosmeticOnList);
        } else {
            throw new AlreadyExists();
        }
    }

        @Transactional
        public ShoppingListCosmeticDto deleteCosmeticShopppingList (Long id, String loggedUserEmail) throws NotFound {
            User user = userRepository.findUserByEmail(loggedUserEmail);
            Long shoppingListId = user.getUserShoppingList()
                    .stream()
                    .findFirst()
                    .map(shoppingList -> shoppingList.getId())
                    .orElseThrow(() -> new NotFound());
            ShoppingListCosmetic shoppingListCosmetic =
                    shoppingListCosmeticRepository.findByCosmeticFromShopIdAndShoppingListId(id, shoppingListId);
            shoppingListCosmeticRepository.delete(shoppingListCosmetic);
            return shoppingListCosmeticMapper.toDto(shoppingListCosmetic);

        }
    }
