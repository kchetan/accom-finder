package com.practo.jedi.service;

import org.springframework.transaction.annotation.Transactional;

import com.practo.jedi.models.PropertyType;

/**
 * This is the Service interface for PropertyType table.It has the methods that are implemented.
 * 
 * @author chetan
 *
 */
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

