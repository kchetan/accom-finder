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

import com.practo.jedi.models.PropertyType;
import com.practo.jedi.service.PropertyTypeService;

@RestController
@RequestMapping("/propertytype")
public class PropertyTypeController {
  @Autowired
  private PropertyTypeService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Iterable<PropertyType>> get() {
    Iterable<PropertyType> dto = service.getAll();
    ResponseEntity<Iterable<PropertyType>> re =
        new ResponseEntity<Iterable<PropertyType>>(dto, HttpStatus.CREATED);
    return re;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<PropertyType> getPropertyType(@PathVariable int id) {
    PropertyType pTypeobj = service.get(id);
    ResponseEntity<PropertyType> re = new ResponseEntity<PropertyType>(pTypeobj, HttpStatus.OK);
    return re;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<PropertyType> create(@RequestBody PropertyType obj) {
    PropertyType pTypeobj = service.create(obj);
    ResponseEntity<PropertyType> re =
        new ResponseEntity<PropertyType>(pTypeobj, HttpStatus.CREATED);
    return re;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<PropertyType> update(@PathVariable int id, @RequestBody PropertyType obj) {
    PropertyType pTypeobj = service.update(obj, id);
    ResponseEntity<PropertyType> re = new ResponseEntity<PropertyType>(pTypeobj, HttpStatus.OK);
    return re;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpServletResponse response) {
    service.delete(id);
    ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return re;
  }

}

