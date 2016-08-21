package com.practo.jedi.service;

import javax.transaction.Transactional;

import com.practo.jedi.models.Listing;
import com.practo.jedi.models.User;

public interface UserService {

  User get(Integer id);

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

