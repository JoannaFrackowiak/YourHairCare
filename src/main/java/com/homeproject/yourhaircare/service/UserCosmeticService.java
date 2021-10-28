package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.model.Cosmetic;
import com.homeproject.yourhaircare.model.User;
import com.homeproject.yourhaircare.model.UserCosmetic;
import com.homeproject.yourhaircare.repository.CosmeticRepository;
import com.homeproject.yourhaircare.repository.UserCosmeticRepository;
import com.homeproject.yourhaircare.repository.UserRepository;
import com.homeproject.yourhaircare.service.dto.UserCosmeticDto;
import com.homeproject.yourhaircare.service.exception.AlreadyExists;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import com.homeproject.yourhaircare.service.mapper.CosmeticMapper;
import com.homeproject.yourhaircare.service.mapper.UserCosmeticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCosmeticService {

    @Autowired
    private UserCosmeticRepository userCosmeticRepository;
    @Autowired
    private UserCosmeticMapper userCosmeticMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CosmeticRepository cosmeticRepository;
    @Autowired
    private CosmeticMapper cosmeticMapper;


    @Transactional
    public List<UserCosmeticDto> getAllUserCosmetic(Long userId) {
//        if(userId != null) {
        return userCosmeticRepository.findAllByUserCosmeticId(userId)
                .stream()
                .map(userCosmetic -> userCosmeticMapper.toDto(userCosmetic))
                .collect(Collectors.toList());
    }

    @Transactional
    public UserCosmeticDto deleteCosmeticUser(Long id, String loggedUserEmail) {
        User user = userRepository.findUserByEmail(loggedUserEmail);
        UserCosmetic userCosmetic = userCosmeticRepository.findByUserCosmeticIdAndCosmeticUserId(user.getId(), id);
        userCosmeticRepository.delete(userCosmetic);
        return userCosmeticMapper.toDto(userCosmetic);
    }


    public UserCosmeticDto addCosmeticToUser(Long id, String loggedUserEmail) throws BadRequest, AlreadyExists {
        if (id == null || loggedUserEmail == null) {
            throw new BadRequest();
        }
        User user = userRepository.findUserByEmail(loggedUserEmail);
        UserCosmetic existUserCosmetic = userCosmeticRepository.findByUserCosmeticIdAndCosmeticUserId(id, user.getId());
        if (existUserCosmetic == null) {
            Cosmetic cosmetic = cosmeticRepository.findCosmeticById(id);
            UserCosmetic userCosmetic = UserCosmetic.builder()
                    .userCosmetic(user)
                    .cosmeticUser(cosmetic)
                    .createdAt(OffsetDateTime.now())
                    .build();
//            existUserCosmetic = userCosmeticRepository.save(userCosmeticMapper.fromDto());
            existUserCosmetic = userCosmeticRepository.save(userCosmetic);
            return userCosmeticMapper.toDto(existUserCosmetic);
        } else {
            throw new AlreadyExists();
        }
    }
}
//
//                return userCosmeticMapper.toDto(existUserCosmetic);
//            } else {
//                throw new AlreadyExists();
//            }
//
//        }
//}

//        return userCosmeticRepository.findAll()
//                .stream()
//                .map(userCosmetic -> userCosmeticMapper.toDto(userCosmetic))
//                .collect(Collectors.toList());
//    }

//}
