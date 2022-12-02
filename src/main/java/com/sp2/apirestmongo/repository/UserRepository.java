package com.sp2.apirestmongo.repository;

import com.sp2.apirestmongo.dto.UserDto;
import com.sp2.apirestmongo.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(String id);
    User createUser(UserDto userDto);
    User updateUser(String id, UserDto userDto);
    Boolean deleteUser(String id);
    User findByEmail(String email);
}
