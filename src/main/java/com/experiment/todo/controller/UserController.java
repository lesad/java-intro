package com.experiment.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.experiment.todo.entity.User;
import com.experiment.todo.exceptions.ResourceNotFoundException;
import com.experiment.todo.repository.UserRepository;

import jakarta.validation.Valid;

/**
 * UserController
 */
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public void deleteUser(@PathVariable Long id) {
    
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    Optional<User> optionalUser = userRepository.findById(id);
    return optionalUser.orElseThrow(() -> new ResourceNotFoundException("User not found " + id));
  }

  @PostMapping
  public User createUser(@RequestBody @Valid User user) {
    return userRepository.save(user);
  }

  @PatchMapping("/{id}/email")
  public User updateUserEmail(@PathVariable Long id, @RequestParam String email) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isEmpty()) {
      throw new ResourceNotFoundException("User not found " + id);
    }

    User user = optionalUser.get();
    user.setEmail(email);
    User updatedUser = userRepository.save(user);

    return updatedUser;
  }
}
