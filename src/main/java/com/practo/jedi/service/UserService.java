package com.practo.jedi.service;

import org.springframework.transaction.annotation.Transactional;

import com.practo.jedi.models.Listing;
import com.practo.jedi.models.User;

/**
 * This is the Service interface for User table.It has the methods that are implemented.
 * 
 * @author chetan
 *
 */
public interface UserService {

  @Transactional
  User get(Integer id);
 
  @Transactional
  User getUserByEmail(String email);

  @Transactional
  User create(User d);

  @Transactional
  User update(User d, int id);

  @Transactional
  void delete(Integer id);

  Iterable<Listing> getUserListings(Integer id);
  
  Listing getUserListingsId(Integer id,Integer lId);

  // Class<User> getDTOClass();

}

