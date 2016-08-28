package com.practo.jedi.dao;

import com.practo.jedi.entity.PropertyTypeEntity;

import java.util.List;

public interface PropertyTypeDao {

  public PropertyTypeEntity getPropertyType(int id);

  public void addPropertyType(PropertyTypeEntity propType);

  public void updatePropertyType(PropertyTypeEntity propType);

  public void deletePropertyType(PropertyTypeEntity propType);

  public List<PropertyTypeEntity> getPropertyTypes();
  
}
