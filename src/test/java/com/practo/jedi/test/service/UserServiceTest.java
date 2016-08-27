package com.practo.jedi.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.practo.jedi.models.User;
import com.practo.jedi.run.Application;
import com.practo.jedi.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

  @Autowired
  private UserService service;

  @Test
  public void testGet() {
    // Get One
    User user = service.get(1);
    assertNotNull(user);
    assertEquals("chetan", user.getName());
    assertEquals("kasireddychetan@gmail.com", user.getEmail());
    assertEquals("9000979804", user.getMobile());
  }

  @Test
  public void testgetUserByEmail() {
    User user = service.getUserByEmail("aditya.bhatia@practo.com");
    assertNotNull(user);
    assertEquals("Aditya Bhatia", user.getName());
    assertEquals("aditya.bhatia@practo.com", user.getEmail());
  }

  @Test
  public void testCreate() {
    User user = new User();
    user.setName("Aditya Bhatia 2");
    user.setEmail("aditya.bhatia2@practo.com");
    user.setMobile("999999999");
    user = service.create(user);
    User dbUser = service.get(user.getId());
    assertNotNull(dbUser);
    assertEquals("Aditya Bhatia 2", dbUser.getName());
    assertEquals("aditya.bhatia2@practo.com", dbUser.getEmail());
    assertEquals("999999999", dbUser.getMobile());
  }

  @Test
  public void testUpdate() {
    User user = service.get(3);
    user.setName("updated name");
    user.setEmail("update@gmail.com");

    service.update(user, 3);

    User dbUser = service.get(3);
    assertNotNull(dbUser);
    assertEquals("updated name", dbUser.getName());
    assertEquals("update@gmail.com", dbUser.getEmail());
  }


  @Test
  public void testDelete() {
    service.delete(2);
    User user = service.get(2);
    assertNull(user);
  }
}
