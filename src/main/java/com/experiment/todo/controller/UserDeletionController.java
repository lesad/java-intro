
package com.experiment.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experiment.todo.repository.UserRepository;

/**
 * UserDeletionController
 */
@RestController
public class UserDeletionController {

  @Autowired
  private UserRepository userRepository;

  @DeleteMapping("/delete-user/{id}")
  public ResponseEntity<?> deleteUser(Long id) {
    userRepository.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
