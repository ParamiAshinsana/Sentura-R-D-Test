package org.example2.testdemo.service;

import org.example2.testdemo.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUser();
    void deleteUser(String id);
    void updateUser(String id, UserDTO userDTO);
}
