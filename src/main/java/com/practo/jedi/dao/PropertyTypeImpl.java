package com.practo.jedi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.practo.jedi.entity.PropertyTypeEntity;
import com.practo.jedi.entity.UserEntity;

@Repository
public class PropertyTypeImpl implements PropertyTypeDao {

  // @Autowired
  // private SessionFactory sessionFactory;

  @Autowired
  private HibernateTemplate template;

  @Transactional
  public PropertyTypeEntity getPropertyType(int id) {
    PropertyTypeEntity res = template.load(PropertyTypeEntity.class, id);
    System.out.println(res.getType());
    return res;
  }

  @Transactional
  public void addPropertyType(PropertyTypeEntity pType) {
    template.save(pType);
  }

  @Transactional
  public void updatePropertyType(PropertyTypeEntity pType) {
    template.update(pType);
  }

  @Transactional
  public void deletePropertyType(PropertyTypeEntity pType) {
    template.delete(pType);
  }


  @Transactional
  public List<PropertyTypeEntity> getPropertyTypes() {
    return template.loadAll(PropertyTypeEntity.class);
  }
  
  @Transactional
  public List<PropertyTypeEntity> getPropertyTypeByType(String[] type){
    
    return null;
  }

}
