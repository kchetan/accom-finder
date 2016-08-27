package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

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

  @Transactional
  public Listing getUserListingsId(Integer id, Integer lId) {
    UserEntity entity = userDao.getUser(id);
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

  @Transactional
  public Iterable<Listing> getUserListings(Integer id) {
    UserEntity entity = userDao.getUser(id);
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

  @Transactional
  public User get(Integer id) {
    UserEntity entity = userDao.getUser(id);
    if (entity == null) {
      return null;
    }
    try {
      User dto = User.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }

  @Transactional
  public User getUserByEmail(String email) {
    UserEntity entity = userDao.getUserByEmail(email);
    try {
      User dto = User.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for Email :" + email, e);
      return null;
    }
  }

  @Transactional
  public User create(User d) {
    UserEntity entity = d.EntityObj();
    Date date = new Date();
    entity.setCreatedOn(date);
    entity.setDeleted(false);
    userDao.addUser(entity);
    d.mergeEntity(entity);
    return d;
  }

  @Transactional
  public User update(User d, int id) {
    UserEntity entity = userDao.getUser(id);
    if (entity != null && !entity.getDeleted()) {
      d.setId(id);
      Date date = new Date();
      entity = d.UpdateEntity(entity);
      entity.setModifiedOn(date);
      userDao.updateUser(entity);
      d.mergeEntity(entity);
      return d;
    }
    return null;
  }

  @Transactional
  public void delete(Integer id) {
    UserEntity entity = userDao.getUser(id);
    if (entity != null && !entity.getDeleted()) {
      Date date = new Date();
      entity.setModifiedOn(date);
      entity.setDeleted(true);
      userDao.updateUser(entity);
    }
  }

}
