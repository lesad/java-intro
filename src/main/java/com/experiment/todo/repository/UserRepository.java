package com.experiment.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.experiment.todo.entity.User;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
