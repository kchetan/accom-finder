package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.dao.AddressDao;
import com.practo.jedi.dao.ListingDao;
import com.practo.jedi.dao.PropertyTypeDao;
import com.practo.jedi.dao.UserDao;
import com.practo.jedi.entity.AddressEntity;
import com.practo.jedi.entity.ListingEntity;
import com.practo.jedi.entity.PropertyTypeEntity;
import com.practo.jedi.entity.UserEntity;
import com.practo.jedi.models.Listing;

@Service
public class ListingServiceImpl implements ListingService {
  private static final Logger logger = LogManager.getLogger(UserService.class);
  // private static final Marker MARKER = MarkerManager.getMarker("myMarker");

  @Autowired
  private ListingDao listingDao;

  @Autowired
  private UserDao userDao;
  @Autowired
  private AddressDao addressDao;
  @Autowired
  private PropertyTypeDao pTypeDao;

  public Iterable<Listing> getAll() {
    Iterable<ListingEntity> entity = listingDao.findAll();
    List<Listing> listings = new ArrayList<Listing>();
    for (ListingEntity listingObj : entity) {
      try {
        if (!listingObj.getDeleted()) {
          Listing dto = Listing.class.newInstance();
          dto.mergeEntity(listingObj);
          listings.add(dto);
        }
      } catch (InstantiationException | IllegalAccessException e) {
        System.out.printf("Exception while DAO get for ID :" + e);
        return null;
      }
    }
    return listings;
  }

  public Listing get(Integer id) {
    ListingEntity entity = listingDao.findOne(id);
    try {
      Listing dto = Listing.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }

  public Listing create(Listing d) {
    ListingEntity entity = d.EntityObj();
    Date date = new Date();
    // ---------
    UserEntity user = userDao.findOne(d.getPostedById());
    entity.setUser(user);
    // ---------
    // ---------
    AddressEntity address = addressDao.findOne(d.getAddressId());
    entity.setAddress(address);
    // ---------
    // ---------
    PropertyTypeEntity pType = pTypeDao.findOne(d.getPropertyId());
    entity.setPropertyType(pType);
    // ---------
    entity = listingDao.save(entity);
    entity.setPostedOn(date);
    d.mergeEntity(entity);
    return d;
  }


  public Listing update(Listing d, int id) {
    ListingEntity entityold = listingDao.findOne(id);
    if (entityold != null && !entityold.getDeleted()) {
      d.setId(id);
      Date date = new Date();
      ListingEntity entity = d.EntityObj();
      entity.setModifiedOn(date);
      entity = listingDao.save(entity);
      d.mergeEntity(entity);
      return d;
    }
    return null;
  }

  public void delete(Integer id) {
    ListingEntity entity = listingDao.findOne(id);
    if (entity != null && !entity.getDeleted()) {
      Date date = new Date();
      entity.setDeleted(true);
      entity.setModifiedOn(date);
      listingDao.save(entity);
    }
  }

}