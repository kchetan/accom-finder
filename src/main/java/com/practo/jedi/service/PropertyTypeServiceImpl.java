package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

  public Iterable<PropertyType> getAll() {
    Iterable<PropertyTypeEntity> entity = pTypeDao.findAll();
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

  public PropertyType get(Integer id) {
    PropertyTypeEntity entity = pTypeDao.findOne(id);
    try {
      PropertyType dto = PropertyType.class.newInstance();
      dto.mergeEntity(entity);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("Exception while DAO get for ID :" + id, e);
      return null;
    }
  }

  public PropertyType create(PropertyType d) {
    PropertyTypeEntity entity = d.EntityObj();
    entity = pTypeDao.save(entity);
    d.mergeEntity(entity);
    return d;
  }


  public PropertyType update(PropertyType d, int id) {
    PropertyTypeEntity entity = pTypeDao.findOne(id);
    if (entity != null && !entity.getDeleted()) {
      d.setId(id);
      Date date = new Date();
      PropertyTypeEntity entityNew = d.EntityObj();
      entityNew.setCreatedOn(date);
      entityNew = pTypeDao.save(entityNew);
      d.mergeEntity(entityNew);
      return d;
    } else
      return null;
  }

  public void delete(Integer id) {
    PropertyTypeEntity entity = pTypeDao.findOne(id);
    if (entity != null && !entity.getDeleted()) {
      Date date = new Date();
      entity.setCreatedOn(date);
      entity.setDeleted(true);
      pTypeDao.save(entity);
    }
  }
}
