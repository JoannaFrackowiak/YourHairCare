package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.model.Cosmetic;
import com.homeproject.yourhaircare.model.ShoppingList;
import com.homeproject.yourhaircare.model.User;
import com.homeproject.yourhaircare.repository.CosmeticRepository;
import com.homeproject.yourhaircare.repository.ShoppingListRepository;
import com.homeproject.yourhaircare.repository.UserRepository;
import com.homeproject.yourhaircare.service.dto.CosmeticDto;
import com.homeproject.yourhaircare.service.dto.CreateAndChangeCosmeticDto;
import com.homeproject.yourhaircare.service.dto.CosmeticToShowDto;
import com.homeproject.yourhaircare.service.exception.AlreadyExists;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import com.homeproject.yourhaircare.service.exception.NotFound;
import com.homeproject.yourhaircare.service.mapper.CosmeticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CosmeticService {

    @Autowired
    private CosmeticRepository cosmeticRepository;
    @Autowired
    private CosmeticMapper cosmeticMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CosmeticService cosmeticService;
    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Transactional
    public List<CosmeticDto> getAllCosmetics(Long brandId, Long typeId) {
        if (brandId != null && typeId != null) {
            return cosmeticRepository.findAllByBrandIdAndTypeId(brandId, typeId)
                    .stream()
                    .map(cosmetic -> cosmeticMapper.toDto(cosmetic))
                    .collect(Collectors.toList());
        }
        return cosmeticRepository.findAll()
                .stream()
                .map(cosmetic -> cosmeticMapper.toDto(cosmetic))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CosmeticDto> getAllCosmeticsForUser(String loggedUserEmail) {
        User user = userRepository.findUserByEmail(loggedUserEmail);
        return user.getCosmeticsOfUser()
                .stream()
                .map(userCosmetic -> userCosmetic.getCosmeticUser())
                .map(cosmetic -> cosmeticMapper.toDto(cosmetic))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CosmeticToShowDto> getAllCosmeticsToShow(String brandName, String typeName) {
        return cosmeticRepository.findAllByBrandNameAndTypeName(brandName, typeName)
                .stream()
                .map(cosmetic -> cosmeticMapper.toDtoTest(cosmetic))
                .collect(Collectors.toList());
    }


    public List<CosmeticToShowDto> getAllCosmeticsToShow() {
        return cosmeticRepository.findAll()
                .stream()
                .map(cosmetic -> cosmeticMapper.toDtoTest(cosmetic))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CosmeticToShowDto> getAllCosmeticsForUserTest(String loggedUserEmail) {
        User user = userRepository.findUserByEmail(loggedUserEmail);
        return user.getCosmeticsOfUser()
                .stream()
                .map(userCosmetic -> userCosmetic.getCosmeticUser())
                .map(cosmetic -> cosmeticMapper.toDtoTest(cosmetic))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CosmeticToShowDto> getAllCosmeticsFromShoppingList(String loggedUserEmail) {
//        User user = userRepository.findUserByEmail(loggedUserEmail);
        ShoppingList shoppingList = shoppingListRepository.findByUserShopListEmail(loggedUserEmail);
        return shoppingList.getCosmeticsFromShop()
                .stream()
                .map(shoppingListCosmetic -> shoppingListCosmetic.getCosmeticFromShop())
                .map(cosmetic -> cosmeticMapper.toDtoTest(cosmetic))
                .collect(Collectors.toList());
    }

    @Transactional
    public CosmeticDto getCosmetic(Long id) throws NotFound {
        return cosmeticRepository.findById(id)
                .map(cosmetic -> cosmeticMapper.toDto(cosmetic))
                .orElseThrow(NotFound::new);
    }

    @Transactional
    public CosmeticDto getCosmetic(String name, String brand, String type) throws NotFound {
        Cosmetic cosmetic = cosmeticRepository.findByBrandNameAndNameAndTypeName(brand, name, type);
        return cosmeticMapper.toDto(cosmetic);
    }

    @Transactional
    public CosmeticToShowDto getCosmeticToShow(String name, String brandName, String typeName) throws NotFound {
        Cosmetic cosmetic = cosmeticRepository.findByBrandNameAndNameAndTypeName(brandName, name, typeName);
        return cosmeticMapper.toDtoTest(cosmetic);
    }

    @Transactional
    public CosmeticDto addNewCosmetic(CreateAndChangeCosmeticDto createCosmeticDto)
            throws BadRequest, AlreadyExists {
        Cosmetic existCosmetic = cosmeticRepository.findByBrandIdAndNameAndTypeId(createCosmeticDto.getBrandId(),
                createCosmeticDto.getName(), createCosmeticDto.getTypeId());
        if (createCosmeticDto.getName() == null) {
            throw new BadRequest();
        } else if (existCosmetic == null) {
            existCosmetic = cosmeticRepository.save(cosmeticMapper.fromDto(createCosmeticDto));
            return cosmeticMapper.toDto(existCosmetic);
        } else {
            throw new AlreadyExists();
        }
    }

    @Transactional
    public CosmeticDto updateCosmetic(CreateAndChangeCosmeticDto changeCosmeticDto, Long id)
            throws AlreadyExists, NotFound {
        return cosmeticService.updateCosmetic(changeCosmeticDto, id);
    }

    @Transactional
    public CosmeticDto deleteCosmetic(Long id) throws NotFound {
        Cosmetic cosmetic = cosmeticRepository.findById(id).orElseThrow(NotFound::new);
        cosmeticRepository.delete(cosmetic);
        return cosmeticMapper.toDto(cosmetic);
    }


}

