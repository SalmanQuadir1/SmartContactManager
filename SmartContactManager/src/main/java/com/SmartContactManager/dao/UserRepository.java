package com.SmartContactManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SmartContactManager.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
