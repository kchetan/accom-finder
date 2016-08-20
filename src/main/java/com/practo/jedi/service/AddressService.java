package com.practo.jedi.service;

import javax.transaction.Transactional;

import com.practo.jedi.models.Address;

public interface AddressService {

  Address get(Integer id);

  @Transactional
  Address create(Address d);

  @Transactional
  Address update(Address d, int id);

  @Transactional
  void delete(Integer id);

  // Class<User> getDTOClass();

}

