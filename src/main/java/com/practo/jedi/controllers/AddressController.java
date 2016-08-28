package com.practo.jedi.controllers;

import com.practo.jedi.models.Address;
import com.practo.jedi.service.AddressService;

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
@RequestMapping("/api/address")
public class AddressController {
  @Autowired
  private AddressService service;

  /**
   * Get Address by id.
   * 
   * @param id {@link Integer}
   * @return {@link ResponseEntity} {@link Address}
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Address> getAddress(@PathVariable int id) {
    Address addressobj = service.get(id);
    ResponseEntity<Address> re = new ResponseEntity<Address>(addressobj, HttpStatus.OK);
    return re;
  }

  /**
   * Create an Address.
   * @param obj {@link Address}
   * @return {@link ResponseEntity} {@link Address} 
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Address> create(@RequestBody Address obj) {
    Address addressobj = service.create(obj);
    ResponseEntity<Address> re = new ResponseEntity<Address>(addressobj, HttpStatus.CREATED);
    return re;
  }

  /**
   * Update Address object of given id with the obj parameters.
   * @param id {@link Integer}
   * @param obj {@link Address}
   * @return {@link ResponseEntity} {@link Address} 
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Address> update(@PathVariable int id, @RequestBody Address obj) {
    Address addressobj = service.update(obj, id);
    ResponseEntity<Address> re = new ResponseEntity<Address>(addressobj, HttpStatus.OK);
    return re;
  }

  /**
   * Delete Address object. 
   * @param id {@link Integer}
   * @param response {@link HttpServletResponse}
   * @return {@link ResponseEntity} {@link Boolean}  
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpServletResponse response) {
    service.delete(id);
    ResponseEntity<Boolean> re = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return re;
  }

}

