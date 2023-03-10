package com.experiment.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

/**
 * User basic entity
 */
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @NotBlank(message = "Name is mandatory")
  private String name;

  public User() {
  }

  public User(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
