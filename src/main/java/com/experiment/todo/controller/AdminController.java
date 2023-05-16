package com.experiment.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experiment.todo.repository.UserRepository;

/**
 * AdminController
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private UserRepository userRepository;

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
  }

  @GetMapping("/message")
  public String getMessage() {
    return "Hello Admin!";
  }
}
