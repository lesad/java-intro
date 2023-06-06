package com.experiment.todo.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.experiment.todo.entity.User;
import com.experiment.todo.repository.UserRepository;

/**
 * UserSeeder
 */
@Component
public class UserSeeder implements CommandLineRunner {

  private final UserRepository userRepository;

  public UserSeeder(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User user1 = new User("Jack Black", "jackblack1", "pass1", "jack.black@gmail.com");
    userRepository.save(user1);

    User user2 = new User("John Doe", "doeTheJohn", "pass2");
    userRepository.save(user2);
  }
}
