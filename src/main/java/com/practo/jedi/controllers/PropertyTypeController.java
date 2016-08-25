package com.practo.jedi.controllers;


import com.practo.jedi.models.PropertyType;
import com.practo.jedi.service.PropertyTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api/propertytype")
public class PropertyTypeController {
  @Autowired
  private PropertyTypeService service;

  /**
   * Get all Properties, Controller.
   * 
   * @return {@link ResponseEntity}
   */
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Iterable<PropertyType>> get() {
    Iterable<PropertyType> dto = service.getAll();
    ResponseEntity<Iterable<PropertyType>> re =
        new ResponseEntity<Iterable<PropertyType>>(dto, HttpStatus.CREATED);
    return re;
  }

  /**
   * Get a property by id, Controllers.
   * 
   * @param id {@link Integer}
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<PropertyType> getPropertyType(@PathVariable int id) {
    PropertyType propTypeObj = service.get(id);
    ResponseEntity<PropertyType> re = new ResponseEntity<PropertyType>(propTypeObj, HttpStatus.OK);
    return re;
  }

  /**
   * Create.
   * 
   * @param obj {@link PropertyType}
   * @return {@link ResponseEntity}
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<PropertyType> create(@RequestBody PropertyType obj) {
    PropertyType propTypeObj = service.create(obj);
    ResponseEntity<PropertyType> re =
        new ResponseEntity<PropertyType>(propTypeObj, HttpStatus.CREATED);
    return re;
  }

  /**
   * Update.
   * 
   * @param id {@link Integer}
   * @param obj {@link PropertyType}
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<PropertyType> update(@PathVariable int id, @RequestBody PropertyType obj) {
    PropertyType propTypeObj = service.update(obj, id);
    ResponseEntity<PropertyType> re = new ResponseEntity<PropertyType>(propTypeObj, HttpStatus.OK);
    return re;
  }

  /**
   * Delete.
   * 
   * @param id {@link Integer}
   * @param response {@link HttpServletResponse}
   * @return {@link ResponseEntity}
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpServletResponse response) {
    service.delete(id);
    ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return re;
  }

}

