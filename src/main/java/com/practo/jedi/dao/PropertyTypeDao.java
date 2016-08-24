package com.practo.jedi.dao;

import java.util.List;

import com.practo.jedi.entity.PropertyTypeEntity;

public interface PropertyTypeDao {

  public PropertyTypeEntity getPropertyType(int id);

  public void addPropertyType(PropertyTypeEntity pType);

  public void updatePropertyType(PropertyTypeEntity pType);

  public void deletePropertyType(PropertyTypeEntity pType);

  public List<PropertyTypeEntity> getPropertyTypes();
  
  public List<PropertyTypeEntity> getPropertyTypeByType(String[] type);

}
