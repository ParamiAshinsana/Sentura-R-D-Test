package org.example2.testdemo.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example2.testdemo.dto.UserDTO;
import org.example2.testdemo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void updateUser(String id, UserDTO userDTO) {

    }
}
