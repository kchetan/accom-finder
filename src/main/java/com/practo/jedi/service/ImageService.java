package com.practo.jedi.service;

import javax.transaction.Transactional;

import com.practo.jedi.models.Image;

public interface ImageService {

  Image get(Integer id);

  @Transactional
  Image create(Image d);

  @Transactional
  Image update(Image d, int id);

  @Transactional
  void delete(Integer id);

  // Class<User> getDTOClass();

}

