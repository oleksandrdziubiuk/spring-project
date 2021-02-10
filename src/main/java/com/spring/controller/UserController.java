package com.spring.controller;

import com.spring.dto.UserResponseDto;
import com.spring.model.User;
import com.spring.service.UserService;
import com.spring.service.impl.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/inject")
    public String inject() {
        User jhon = new User();
        jhon.setName("Jhon");
        jhon.setLastName("Doe");
        userService.add(jhon);
        User bob = new User();
        bob.setName("Bob");
        bob.setLastName("Thomson");
        userService.add(bob);
        User alice = new User();
        alice.setName("Alice");
        alice.setLastName("Alison");
        userService.add(alice);
        User bill = new User();
        bill.setName("Bill");
        bill.setLastName("Gert");
        userService.add(bill);
        return "injected";
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        User user = userService.get(id);
        return userMapper.toDto(user);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
