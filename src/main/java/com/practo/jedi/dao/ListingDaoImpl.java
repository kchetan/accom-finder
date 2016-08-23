package com.practo.jedi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.practo.jedi.entity.ListingEntity;

@Repository
public class ListingDaoImpl implements ListingDao {

  // @Autowired
  // private SessionFactory sessionFactory;

  @Autowired
  private HibernateTemplate template;

  @Transactional
  public ListingEntity getListing(int id) {
    ListingEntity res = template.load(ListingEntity.class, id);
    return res;
  }


  @Transactional
  public void addListing(ListingEntity listing) {
    template.save(listing);
  }

  @Transactional
  public void updateListing(ListingEntity listing) {
    template.update(listing);
  }

  @Transactional
  public void deleteListing(ListingEntity listing) {
    template.delete(listing);
  }

  public List<ListingEntity> getListings() {
    return template.loadAll(ListingEntity.class);
  }



}
