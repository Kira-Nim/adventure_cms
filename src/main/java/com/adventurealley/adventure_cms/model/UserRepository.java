package com.adventurealley.adventure_cms.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//CrudRepository (interface) that extends from JpaRepository.
public interface UserRepository extends JpaRepository<User, Integer> {

    // Method for getting a user from db with a given username
    public List<User> findByUsername(String username);
}
