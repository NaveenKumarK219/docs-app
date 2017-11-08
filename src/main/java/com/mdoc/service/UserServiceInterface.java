package com.mdoc.service;

import java.util.List;

import com.mdoc.model.User;

public interface UserServiceInterface {

    public User findUserByEmail(String email);

    public void saveUser(User user);

    public List<User> getUsers();

}
