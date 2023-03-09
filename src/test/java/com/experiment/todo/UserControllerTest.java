package com.experiment.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.experiment.todo.entity.User;

/**
 * UserControllerTest
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void testGetAllUsers() {
    ResponseEntity<List<User>> responseEntity =
        restTemplate.exchange("/users", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
    List<User> users = responseEntity.getBody();
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Status is not OK");
    assertNotNull(users, "Users is null");
    assertEquals(2, users.size(), "There are not 2 users");
  }

}
