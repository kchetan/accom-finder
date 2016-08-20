package com.practo.jedi.service;

import javax.transaction.Transactional;

import com.practo.jedi.models.Listing;

public interface ListingService {

  Listing get(Integer id);

  @Transactional
  Listing create(Listing d);

  @Transactional
  Listing update(Listing d, int id);

  @Transactional
  void delete(Integer id);

  @Transactional
  Iterable<Listing> getAll();


  // Class<User> getDTOClass();

}

