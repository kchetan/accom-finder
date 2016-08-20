package com.practo.jedi.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.models.Address;
import com.practo.jedi.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
  @Autowired
  private AddressService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Address> getPropertyType(@PathVariable int id) {
    Address addressobj = service.get(id);
    ResponseEntity<Address> re = new ResponseEntity<Address>(addressobj, HttpStatus.OK);
    return re;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Address> create(@RequestBody Address obj) {
    Address addressobj = service.create(obj);
    ResponseEntity<Address> re = new ResponseEntity<Address>(addressobj, HttpStatus.CREATED);
    return re;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Address> update(@PathVariable int id, @RequestBody Address obj) {
    Address addressobj = service.update(obj, id);
    ResponseEntity<Address> re = new ResponseEntity<Address>(addressobj, HttpStatus.OK);
    return re;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpServletResponse response) {
    service.delete(id);
    ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return re;
  }

}

