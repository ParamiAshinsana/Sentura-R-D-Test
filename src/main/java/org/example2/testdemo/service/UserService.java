package org.example2.testdemo.service;

import org.example2.testdemo.dto.UserDTO;

import java.io.IOException;

public interface UserService {
    String createUser(UserDTO userDTO) throws IOException;

    String deleteUser(String id) throws IOException;
    String updateUser(String id, UserDTO userDTO) throws IOException;

    String getUserById(String id) throws IOException;

    String getAllUsers() throws IOException;
}
