package com.practo.jedi.service;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.transaction.annotation.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.dao.ImageDao;
import com.practo.jedi.dao.ListingDao;
import com.practo.jedi.entity.ImageEntity;
import com.practo.jedi.entity.ListingEntity;
import com.practo.jedi.entity.UserEntity;
import com.practo.jedi.models.Address;
import com.practo.jedi.models.Image;

@Service
public class ImageServiceImpl implements ImageService {
  private static final Logger logger = LogManager.getLogger(UserService.class);
  // private static final Marker MARKER = MarkerManager.getMarker("myMarker");

  @Autowired
  private ImageDao imageDao;
  
  @Autowired
  private ListingDao listingDao;

  /**
   * Get an Image Object based on id.
   * 
   * @param id {@link Image}
   * @return {@link Address}
   */
  @Transactional
  public Image get(Integer id) {
    ImageEntity entity = imageDao.getImage(id);
    if (entity == null) {
      return null;
    }
    try {
      Image dto = Image.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }
  
  /**
   * Create an Image Object.
   * 
   * @param d {@link Image}
   * @return {@link Image}
   */
  @Transactional
  public Image create(Image d) {
    ImageEntity entity = d.entityObj();
    Date date = new Date();
    entity.setCreatedOn(date);
    ListingEntity listing = listingDao.getListing(d.getlistingId());
    entity.setListing(listing);
    imageDao.addImage(entity);
    d.mergeEntity(entity);
    return d;
  }

  /**
   * Update an Image Object based on id.
   * 
   * @param d {@link Image}
   * @param id {@link Integer}
   * @return {@link Image}
   */
  @Transactional
  public Image update(Image d, int id) {
    ImageEntity entity = imageDao.getImage(id);
    if (entity != null && !entity.getDeleted()) {
      d.setId(id);
      entity = d.updateEntity(entity);
      Date date = new Date();
      entity.setModifiedOn(date);
      imageDao.updateImage(entity);
      d.mergeEntity(entity);
      return d;
    }
    return null;
  }

  /**
   * delete an Image Object based on id.
   * 
   * @param id {@link Integer}
   */
  @Transactional
  public void delete(Integer id) {
    ImageEntity entity = imageDao.getImage(id);
    if (entity != null && !entity.getDeleted()) {
      Date date = new Date();
      entity.setModifiedOn(date);
      entity.setDeleted(true);
      imageDao.deleteImage(entity);
    }
  }

}
