package com.practo.jedi.service;

import org.springframework.transaction.annotation.Transactional;

import com.practo.jedi.models.Address;

/**
 * This is the Service interface for Address table.It has the methods that are implemented.
 * Get create update and delete .
 * 
 * @author chetan
 *
 */
public interface AddressService {

  Address get(Integer id);

  @Transactional
  Address create(Address addr);

  @Transactional
  Address update(Address addr, int id);

  @Transactional
  void delete(Integer id);

  // Class<User> getDTOClass();

}

