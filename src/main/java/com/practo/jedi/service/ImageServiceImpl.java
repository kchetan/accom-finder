package com.practo.jedi.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.dao.ImageDao;
import com.practo.jedi.entity.ImageEntity;
import com.practo.jedi.models.Image;

@Service
public class ImageServiceImpl implements ImageService {
  private static final Logger logger = LogManager.getLogger(UserService.class);
  // private static final Marker MARKER = MarkerManager.getMarker("myMarker");

  @Autowired
  private ImageDao imageDao;

  @Transactional
  public Image get(Integer id) {
    ImageEntity entity = imageDao.getImage(id);
    try {
      Image dto = Image.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }
  
  @Transactional
  public Image create(Image d) {
    ImageEntity entity = d.EntityObj();
    Date date = new Date();
    entity.setCreatedOn(date);
    imageDao.addImage(entity);
    d.mergeEntity(entity);
    return d;
  }

  @Transactional
  public Image update(Image d, int id) {
    ImageEntity entity = imageDao.getImage(id);
    if (entity != null && !entity.getDeleted()) {
      d.setId(id);
      entity = d.UpdateEntity(entity);
      Date date = new Date();
      entity.setModifiedOn(date);
      imageDao.updateImage(entity);
      d.mergeEntity(entity);
      return d;
    }
    return null;
  }

  @Transactional
  public void delete(Integer id) {
    ImageEntity entity = imageDao.getImage(id);
    if (entity != null && !entity.getDeleted()) {
      Date date = new Date();
      entity.setModifiedOn(date);
      entity.setDeleted(true);
      imageDao.updateImage(entity);
    }
  }

}
