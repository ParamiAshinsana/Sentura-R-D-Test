package org.example2.testdemo.controller;

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

    @PostMapping("/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") String id) throws IOException {
        System.out.println(id);
        String response = userService.getUserById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllUsers() throws IOException {
        String response = userService.getAllUsers();
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateUsers(@RequestBody UserDTO userDTO, @PathVariable ("id") String id) throws IOException {
        System.out.println(id);
        String response = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}/trash")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) throws IOException {
        System.out.println(id);
        String response = userService.deleteUser(id);
        return ResponseEntity.ok(response);
    }

}
