package org.example2.testdemo.service;

import org.example2.testdemo.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface UserService {
    String createUser(UserDTO userDTO) throws IOException;
    List<UserDTO> getAllUser();
    void deleteUser(String id);
    void updateUser(String id, UserDTO userDTO);
}
