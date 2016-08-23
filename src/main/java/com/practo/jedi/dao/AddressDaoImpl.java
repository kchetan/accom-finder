package com.practo.jedi.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.practo.jedi.entity.AddressEntity;

@Repository
public class AddressDaoImpl implements AddressDao {

  // @Autowired
  // private SessionFactory sessionFactory;

  @Autowired
  private HibernateTemplate template;

  @Transactional
  public AddressEntity getAddress(int id) {
    AddressEntity res = template.load(AddressEntity.class, id);
    return res;
  }



  @Transactional
  public void addAddress(AddressEntity address) {
    template.save(address);
  }

  @Transactional
  public void updateAddress(AddressEntity address) {
    template.update(address);
  }

  @Transactional
  public void deleteAddress(AddressEntity address) {
    template.delete(address);
  }


}
