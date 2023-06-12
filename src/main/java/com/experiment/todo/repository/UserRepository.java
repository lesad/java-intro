package com.experiment.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.experiment.todo.entity.User;
import com.experiment.todo.exceptions.ResourceNotFoundException;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  default String handleResourceNotFoundException(ResourceNotFoundException ex) {
    return ex.getMessage();
  }

}
