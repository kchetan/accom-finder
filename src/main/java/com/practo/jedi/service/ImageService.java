package com.practo.jedi.service;

import org.springframework.transaction.annotation.Transactional;

import com.practo.jedi.models.Image;

public interface ImageService {

  Image get(Integer id);

  @Transactional
  Image create(Image d);

  @Transactional
  Image update(Image d, int id);

  @Transactional
  void delete(Integer id);

}

