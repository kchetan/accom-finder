package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.dao.UserDao;
import com.practo.jedi.entity.ListingEntity;
import com.practo.jedi.entity.UserEntity;
import com.practo.jedi.models.Listing;
import com.practo.jedi.models.User;

@Service
public class UserServiceImpl implements UserService {
  private static final Logger logger = LogManager.getLogger(UserService.class);
  // private static final Marker MARKER = MarkerManager.getMarker("myMarker");

  @Autowired
  private UserDao userDao;

  public Listing getUserListingsId(Integer id, Integer lId) {
    UserEntity entity = userDao.findOne(id);
    try {
      User dto = User.class.newInstance();
      dto.mergeEntity(entity);
      for (ListingEntity each : dto.getListings()) {
        if (lId == each.getId()) {
          Listing listing = new Listing();
          listing.mergeEntity(each);
          return listing;
        }
      }
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
    }
    return null;
  }

  public Iterable<Listing> getUserListings(Integer id) {
    UserEntity entity = userDao.findOne(id);
    try {
      User dto = User.class.newInstance();
      dto.mergeEntity(entity);
      List<Listing> listings = new ArrayList<Listing>();
      for (ListingEntity each : dto.getListings()) {
        Listing listing = new Listing();
        listing.mergeEntity(each);
        listings.add(listing);
      }
      return listings;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }

  public User get(Integer id) {
    UserEntity entity = userDao.findOne(id);
    try {
      User dto = User.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }

  public User create(User d) {
    UserEntity entity = d.EntityObj();
    Date date = new Date();
    entity.setCreatedOn(date);
    entity = userDao.save(entity);
    d.mergeEntity(entity);
    return d;
  }


  public User update(User d, int id) {
    UserEntity entity = userDao.findOne(id);
    if (entity != null && !entity.getDeleted()) {
      d.setId(id);
      Date date = new Date();
      UserEntity entityNew = d.EntityObj();
      entityNew.setModifiedOn(date);
      entityNew = userDao.save(entityNew);
      d.mergeEntity(entityNew);
      return d;
    }
    return null;
  }

  public void delete(Integer id) {
    UserEntity entity = userDao.findOne(id);
    if (entity != null && !entity.getDeleted()) {
      Date date = new Date();
      entity.setModifiedOn(date);
      entity.setDeleted(true);
      userDao.save(entity);
    }
  }

}
