package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practo.jedi.dao.AddressDao;
import com.practo.jedi.dao.ListingDao;
import com.practo.jedi.dao.PropertyTypeDao;
import com.practo.jedi.dao.UserDao;
import com.practo.jedi.entity.AddressEntity;
import com.practo.jedi.entity.ListingEntity;
import com.practo.jedi.entity.PropertyTypeEntity;
import com.practo.jedi.entity.UserEntity;
import com.practo.jedi.models.Address;
import com.practo.jedi.models.Listing;
import com.practo.jedi.models.ListingFilter;

/**
 * This is the Service implementation for Listing table.It has the methods that are implemented.
 * Get create update and delete,also search filters based on 
 * 
 * @author chetan
 *
 */
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
  private PropertyTypeDao propropTypeDao;

  /**
   * Search a Listing Object Filters .Check Filters class for more reason
   * 
   * @param filterObj {@link Listing}
   * @param pageable {@link Pageable}
   * @return {@link Listing}
   */
  @Transactional
  public Iterable<Listing> search(ListingFilter filterObj, Pageable pageable) {
    Iterable<ListingEntity> entities = listingDao.filter(filterObj, pageable);
    ArrayList<Listing> listings = new ArrayList<Listing>();
    for (ListingEntity entity : entities) {
      Listing listing = new Listing();
      listing.mergeEntity(entity);
      listings.add(listing);
    }
    return listings;
  }

  /**
   * Get all Listing Object paginated.
   * 
   * @param pageable {@link Pageable}
   * @return {@link Listing}
   */
  @Transactional
  public Iterable<Listing> getAll(Pageable pageable) {
    Iterable<ListingEntity> entity = listingDao.getListings(pageable);
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

  /**
   * Get a Listing Object based on id.
   * 
   * @param id {@link Integer}
   * @return {@link Listing}
   */
  @Transactional
  public Listing get(Integer id) {
    ListingEntity entity = listingDao.getListing(id);
    if (entity == null) {
      return null;
    }
    try {
      Listing dto = Listing.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }

  /**
   * Create a Listing Obj based on id.
   * 
   * @param d {@link Listing}
   * @return {@link Listing}
   */
  @Transactional
  public Listing create(Listing d) {
    ListingEntity entity = d.EntityObj();
    Date date = new Date();
    entity.setPostedOn(date);
    // ---------
    UserEntity user = userDao.getUser(d.getPostedById());
    entity.setUser(user);
    // ---------
    // ---------
    AddressEntity address = addressDao.getAddress(d.getAddressId());
    entity.setAddress(address);
    // ---------
    // ---------
    PropertyTypeEntity propType = propropTypeDao.getPropertyType(d.getPropertyId());
    entity.setPropertyType(propType);
    // ---------
    listingDao.addListing(entity);
    d.mergeEntity(entity);
    return d;
  }

  /**
   * update a Listing Object based on id.
   * 
   * @param d {@link Listing}
   * @return {@link Listing}
   */
  @Transactional
  public Listing update(Listing d, int id) {
    ListingEntity entity = listingDao.getListing(id);
    if (entity != null && !entity.getDeleted()) {
      d.setId(id);
      Date date = new Date();
      entity = d.updateEntity(entity);
      entity.setModifiedOn(date);
      // ----------
      UserEntity user = userDao.getUser(d.getPostedById());
      entity.setUser(user);
      // ---------
      // ---------
      AddressEntity address = addressDao.getAddress(d.getAddressId());
      entity.setAddress(address);
      // ---------
      // ---------
      PropertyTypeEntity propType = propropTypeDao.getPropertyType(d.getPropertyId());
      entity.setPropertyType(propType);
      // ---------
      listingDao.updateListing(entity);
      d.mergeEntity(entity);
      return d;
    }
    return null;
  }

  /**
   * delete an Listing Obj based on id.
   * 
   * @param id {@link Integer}
   */
  @Transactional
  public void delete(Integer id) {
    ListingEntity entity = listingDao.getListing(id);
    if (entity != null && !entity.getDeleted()) {
      Date date = new Date();
      entity.setDeleted(true);
      entity.setModifiedOn(date);
      listingDao.deleteListing(entity);
    }
  }

}
