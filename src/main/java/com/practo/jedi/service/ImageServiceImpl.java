package com.practo.jedi.service;

import java.util.Date;

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

  public Image get(Integer id) {
    ImageEntity entity = imageDao.findOne(id);
    try {
      Image dto = Image.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }

  public Image create(Image d) {
    ImageEntity entity = d.EntityObj();
    entity = imageDao.save(entity);
    Date date = new Date();
    entity.setCreatedOn(date);
    d.mergeEntity(entity);
    return d;
  }


  public Image update(Image d, int id) {
    ImageEntity entityold = imageDao.findOne(id);
    if (entityold != null && !entityold.getDeleted()) {
      d.setId(id);
      ImageEntity entity = d.EntityObj();
      entity = imageDao.save(entity);
      Date date = new Date();
      entity.setModifiedOn(date);
      d.mergeEntity(entity);
      return d;
    }
    return null;
  }

  public void delete(Integer id) {
    ImageEntity entity = imageDao.findOne(id);
    if (entity != null && !entity.getDeleted()) {
      Date date = new Date();
      entity.setModifiedOn(date);
      entity.setDeleted(true);
      imageDao.save(entity);
    }
  }

}
