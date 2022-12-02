package com.sp2.apirestmongo.service;

import com.sp2.apirestmongo.dto.UserDto;
import com.sp2.apirestmongo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String id);
    User createUser(UserDto userDto);
    User updateUser(String id, UserDto userDto);
    Boolean deleteUser(String id);
    User findByEmail(String email);
}
