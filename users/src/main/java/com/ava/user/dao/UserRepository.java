package com.ava.user.dao;


import com.ava.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findUserByEmail(String user);

    Users findUserByUserId(int user);
}
