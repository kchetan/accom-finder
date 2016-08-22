package com.practo.jedi.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practo.jedi.models.User;
import com.practo.jedi.run.Application;
import com.practo.jedi.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class UserControllerTest {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
 
  @Autowired
  private UserService service;

  private RestTemplate restTemplate = new TestRestTemplate();

 
  @Test
  public void testGetUser() {
    int id = 1;
    User apiResponse = restTemplate.getForObject("http://localhost:8080/users/" + id, User.class);
    User user = service.get(id);
    System.out.println(apiResponse.getEmail());
    // Verify that the data from the API and data saved in the DB are same
    assertNotNull("Expected non null object",apiResponse);
    assertEquals(user.getEmail(), apiResponse.getEmail());
    assertEquals(user.getName(), apiResponse.getName());
    assertEquals(user.getMobile(), apiResponse.getMobile());
    //assertTrue(user.getListings() == apiResponse.getListings());
  }
}
