package org.example2.testdemo.controller;

import lombok.RequiredArgsConstructor;
import org.example2.testdemo.dto.UserDTO;
import org.example2.testdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) throws IOException {
        System.out.println(userDTO.getEmail());
        String response = userService.createUser(userDTO);
        return ResponseEntity.ok(response);
    }
}
