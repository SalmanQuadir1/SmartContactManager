package com.SmartContactManager.dao;

import org.springframework.data.repository.CrudRepository;

import com.SmartContactManager.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
