package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.dao.PropertyTypeDao;
import com.practo.jedi.entity.PropertyTypeEntity;
import com.practo.jedi.models.PropertyType;


@Service
public class PropertyTypeServiceImpl implements PropertyTypeService {
  private static final Logger logger = LogManager.getLogger(UserService.class);
  // private static final Marker MARKER = MarkerManager.getMarker("myMarker");

  @Autowired
  private PropertyTypeDao pTypeDao;

  @Transactional
  public Iterable<PropertyType> getAll() {
    Iterable<PropertyTypeEntity> entity = pTypeDao.getPropertyTypes();
    List<PropertyType> ptypelist = new ArrayList<PropertyType>();
    for (PropertyTypeEntity pTypeObj : entity) {
      try {
        if (!pTypeObj.getDeleted()) {
          PropertyType dto = PropertyType.class.newInstance();
          dto.mergeEntity(pTypeObj);
          ptypelist.add(dto);
        }
      } catch (InstantiationException | IllegalAccessException e) {
        System.out.printf("Exception while DAO get for ID :" + e);
        return null;
      }
    }
    return ptypelist;
  }

  @Transactional
  public PropertyType get(Integer id) {
    PropertyTypeEntity entity = pTypeDao.getPropertyType(id);
    if (entity == null) {
      return null;
    }
    try {
      PropertyType dto = PropertyType.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }

  @Transactional
  public PropertyType create(PropertyType d) {
    PropertyTypeEntity entity = d.EntityObj();
    Date date = new Date();
    entity.setCreatedOn(date);
    entity.setDeleted(false);
    pTypeDao.addPropertyType(entity);
    d.mergeEntity(entity);
    return d;
  }

  @Transactional
  public PropertyType update(PropertyType d, int id) {
    PropertyTypeEntity entity = pTypeDao.getPropertyType(id);
    if (entity != null && !entity.getDeleted()) {
      d.setId(id);
      Date date = new Date();
      entity = d.UpdateEntity(entity);
      entity.setModifiedOn(date);
      pTypeDao.updatePropertyType(entity);
      d.mergeEntity(entity);
      return d;
    } else
      return null;
  }

  @Transactional
  public void delete(Integer id) {
    PropertyTypeEntity entity = pTypeDao.getPropertyType(id);
    if (entity != null && !entity.getDeleted()) {
      Date date = new Date();
      entity.setModifiedOn(date);
      entity.setDeleted(true);
      pTypeDao.deletePropertyType(entity);
    }
  }
}
