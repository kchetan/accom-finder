package com.practo.jedi.service;

import org.springframework.transaction.annotation.Transactional;

import com.practo.jedi.models.Image;

/**
 * This is the Service interface for Image table.It has the methods that are implemented.
 * 
 * @author chetan
 *
 */
public interface ImageService {

  Image get(Integer id);

  @Transactional
  Image create(Image d);

  @Transactional
  Image update(Image d, int id);

  @Transactional
  void delete(Integer id);

}

