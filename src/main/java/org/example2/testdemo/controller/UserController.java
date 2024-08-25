package org.example2.testdemo.controller;

import lombok.RequiredArgsConstructor;
import org.example2.testdemo.dto.UserDTO;
import org.example2.testdemo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/")
    public UserDTO saveUsers(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }
}
