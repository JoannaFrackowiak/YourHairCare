package com.homeproject.yourhaircare.service;

import com.homeproject.yourhaircare.model.User;
import com.homeproject.yourhaircare.repository.UserRepository;
import com.homeproject.yourhaircare.service.dto.CreateUpdateUserDto;
import com.homeproject.yourhaircare.service.dto.UserDto;
import com.homeproject.yourhaircare.service.exception.AlreadyExists;
import com.homeproject.yourhaircare.service.exception.BadRequest;
import com.homeproject.yourhaircare.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public UserDto addNewUser(@RequestBody CreateUpdateUserDto createUpdateUserDto)
            throws BadRequest, AlreadyExists {
        User existUser = userRepository.findUserByEmail(createUpdateUserDto.getEmail());
        if (createUpdateUserDto.getName().isEmpty() && createUpdateUserDto.getEmail().isEmpty()
                && createUpdateUserDto.getPassword().isEmpty()) {
            throw new BadRequest();
        } else if (existUser == null) {
            existUser = userRepository.save(userMapper.fromDto(createUpdateUserDto));
            return userMapper.toDto(existUser);
        } else {
            throw new AlreadyExists();
        }
    }
}
