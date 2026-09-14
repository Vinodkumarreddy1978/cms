package com.cms.demo.service;


import com.cms.demo.dto.UserDto;
import com.cms.demo.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByUsername(String username);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}