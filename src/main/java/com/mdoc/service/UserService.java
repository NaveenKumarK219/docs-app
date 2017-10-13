package com.mdoc.service;

import com.mdoc.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);

}
