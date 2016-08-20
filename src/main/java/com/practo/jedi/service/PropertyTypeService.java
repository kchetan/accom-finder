package com.practo.jedi.service;

import javax.transaction.Transactional;

import com.practo.jedi.models.PropertyType;

public interface PropertyTypeService {

  PropertyType get(Integer id);

  @Transactional
  PropertyType create(PropertyType d);

  @Transactional
  PropertyType update(PropertyType d, int id);

  @Transactional
  void delete(Integer id);
  
  @Transactional
  Iterable<PropertyType> getAll();

  // Class<User> getDTOClass();

}

