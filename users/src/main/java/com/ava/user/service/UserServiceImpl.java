package com.ava.user.service;

import com.ava.user.dao.UserRepository;
import com.ava.user.entity.Users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Users createUser(Users users) {
        LOGGER.info("creating user for {}",users);
        users.setLastUpdateDate(LocalDate.now());
        return userRepo.save(users);
    }

    @Override
    public Users updateUser(Users users) {
        LOGGER.info("get usere by email for {}",users.getEmail());
        Users usersToUpdate = userRepo.findUserByEmail(users.getEmail());
        usersToUpdate.setFirstName(users.getFirstName());
        usersToUpdate.setLastName(users.getLastName());
        usersToUpdate.setAddress(users.getAddress());
        usersToUpdate.setStatus(users.getStatus());
        LOGGER.info("Saving user after update for {}",users.getEmail());
        return userRepo.save(usersToUpdate);
    }

    @Override
    public Users getUser(Users users) {
        LOGGER.info("get usere by for id {}",users.getUserId());
        return userRepo.findUserByUserId(users.getUserId());
    }

    @Override
    public Users getUserByEmail(Users usr) {
        LOGGER.info("get usere by email for {}",usr.getEmail());
        return userRepo.findUserByEmail(usr.getEmail());
    }

}
