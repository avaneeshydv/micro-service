package com.ava.user.service;

import com.ava.user.entity.Users;


public interface UserService {

    Users createUser(Users users);

    Users updateUser(Users users);

    Users getUser(Users users);

    Users getUserByEmail(Users usr);
}
