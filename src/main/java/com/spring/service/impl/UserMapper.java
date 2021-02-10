package com.spring.service.impl;

import com.spring.dto.UserResponseDto;
import com.spring.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }

    public User fromDto(UserResponseDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        return user;
    }
}
