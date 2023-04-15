package com.project.crud.service;

import com.project.crud.entity.User;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();

    long userCount();

    User saveUser(User user);

    User getUserById(Integer id);

    void deleteById(Integer id);

    User updateUser(User user);
}
