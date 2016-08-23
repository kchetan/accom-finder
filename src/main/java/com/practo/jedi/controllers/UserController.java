package com.practo.jedi.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.dao.SimpleUserDao;
import com.practo.jedi.entity.UserEntity;
import com.practo.jedi.models.Listing;
import com.practo.jedi.models.User;
import com.practo.jedi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService service;

  @Autowired
  private SimpleUserDao dao;


  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<User> getUser(@PathVariable int id) {
    List<UserEntity> user = dao.list();
    System.out.println(user);
    User dto = service.get(id);
    ResponseEntity<User> re = new ResponseEntity<User>(dto, HttpStatus.CREATED);
    return re;
  }

  @RequestMapping(value = "/{id}/listings", method = RequestMethod.GET)
  public ResponseEntity<Iterable<Listing>> getUserListings(@PathVariable int id) {
    Iterable<Listing> dto = service.getUserListings(id);
    ResponseEntity<Iterable<Listing>> re =
        new ResponseEntity<Iterable<Listing>>(dto, HttpStatus.CREATED);
    return re;
  }

  @RequestMapping(value = "/{id}/listings/{lId}", method = RequestMethod.GET)
  public ResponseEntity<Listing> getUserListings(@PathVariable int id, @PathVariable int lId) {
    Listing dto = service.getUserListingsId(id, lId);
    ResponseEntity<Listing> re = new ResponseEntity<Listing>(dto, HttpStatus.CREATED);
    return re;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<User> create(@RequestBody User obj) {
    User userobj = service.create(obj);
    ResponseEntity<User> re = new ResponseEntity<User>(userobj, HttpStatus.CREATED);
    return re;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<User> update(@RequestBody User obj, @PathVariable int id) {
    User userobj = service.update(obj, id);
    ResponseEntity<User> re = new ResponseEntity<User>(userobj, HttpStatus.OK);
    return re;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpServletResponse response) {
    service.delete(id);
    ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return re;
  }

}

