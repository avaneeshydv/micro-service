package com.ava.user.service;

import com.ava.user.dao.UserRepository;
import com.ava.user.entity.Users;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Users createUser(Users users) {
        users.setLastUpdateDate(LocalDate.now());
        return userRepo.save(users);
    }

    @Override
    public Users updateUser(Users users) {
        Users usersToUpdate = userRepo.findUserByEmail(users.getEmail());
        usersToUpdate.setFirstName(users.getFirstName());
        usersToUpdate.setLastName(users.getLastName());
        usersToUpdate.setAddress(users.getAddress());
        usersToUpdate.setStatus(users.getStatus());
        return userRepo.save(usersToUpdate);
    }

    @Override
    public Users getUser(Users users) {
        return userRepo.findUserByUserId(users.getUserId());
    }

    @Override
    public Users getUserByEmail(Users usr) {
        return userRepo.findUserByEmail(usr.getEmail());
    }

}
