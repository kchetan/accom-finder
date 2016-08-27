package com.practo.jedi.dao;

import java.util.List;


import com.practo.jedi.entity.PropertyTypeEntity;
import com.practo.jedi.entity.PropertyTypeEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;




@Repository
public class PropertyTypeImpl implements PropertyTypeDao {

  // @Autowired
  // private SessionFactory sessionFactory;

  @Autowired
  private HibernateTemplate template;

  @Transactional
  public PropertyTypeEntity getPropertyType(int id) {
    DetachedCriteria criteria = DetachedCriteria.forClass(PropertyTypeEntity.class);
    criteria = criteria.add(Restrictions.eq("deleted", false));
    criteria = criteria.add(Restrictions.eq("id", id));
    Iterable<PropertyTypeEntity> result =
        (Iterable<PropertyTypeEntity>) template.findByCriteria(criteria);
    for (PropertyTypeEntity iter : result) {
      return iter;
    }
    return null;
  }

  @Transactional
  public void addPropertyType(PropertyTypeEntity propType) {
    template.save(propType);
  }

  @Transactional
  public void updatePropertyType(PropertyTypeEntity propType) {
    template.update(propType);
  }

  @Transactional
  public void deletePropertyType(PropertyTypeEntity propType) {
    template.update(propType);
  }


  @Transactional
  public List<PropertyTypeEntity> getPropertyTypes() {
    return template.loadAll(PropertyTypeEntity.class);
  }

  @Transactional
  public List<PropertyTypeEntity> getPropertyTypeByType(String[] type) {

    return null;
  }

}
