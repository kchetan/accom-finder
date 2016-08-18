package com.practo.jedi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.dao.UserDao;
import com.practo.jedi.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserDao userDao;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<User> get() {
    return userDao.findAll();
  }

}

