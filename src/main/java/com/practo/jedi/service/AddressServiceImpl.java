package com.practo.jedi.service;

import com.practo.jedi.dao.AddressDao;
import com.practo.jedi.entity.AddressEntity;
import com.practo.jedi.models.Address;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * This is the Service implementation for Address table.It has the methods that are implemented.
 * Get create update and delete .
 * 
 * @author chetan
 *
 */
@Service
public class AddressServiceImpl implements AddressService {
  private static final Logger logger = LogManager.getLogger(UserService.class);
  // private static final Marker MARKER = MarkerManager.getMarker("myMarker");

  @Autowired
  private AddressDao addressDao;

  /**
   * Get an Address Obj based on id.
   * 
   * @param id {@link Integer}
   * @return {@link Address}
   */
  @Transactional
  public Address get(Integer id) {
    AddressEntity entity = addressDao.getAddress(id);
    if (entity == null) {
      return null;
    }
    try {
      Address dto = Address.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }

  /**
   * Create an Address Object.
   * 
   * @param d {@link Address}
   * @return {@link Address}
   */
  @Transactional
  public Address create(Address d) {
    AddressEntity entity = d.EntityObj();
    Date date = new Date();
    entity.setCreatedOn(date);
    addressDao.addAddress(entity);
    d.mergeEntity(entity);
    return d;
  }

  /**
   * Update address Object.
   * 
   * @param d {@link Address}
   * @param id {@link Integer}
   * @return {@link Address}
   */
  @Transactional
  public Address update(Address d, int id) {
    AddressEntity entity = addressDao.getAddress(id);
    if (entity != null && !entity.getDeleted()) {
      d.setId(id);
      entity = d.UpdateEntity(entity);
      addressDao.updateAddress(entity);
      d.mergeEntity(entity);
      return d;
    }
    return null;
  }

  /**
   * Delete an Address Obj based on id.
   * @param id {@link Integer}
   */
  @Transactional
  public void delete(Integer id) {
    AddressEntity entity = addressDao.getAddress(id);
    if (entity != null && !entity.getDeleted()) {
      Date date = new Date();
      entity.setModifiedOn(date);
      entity.setDeleted(true);
      addressDao.updateAddress(entity);
    }
  }

}
