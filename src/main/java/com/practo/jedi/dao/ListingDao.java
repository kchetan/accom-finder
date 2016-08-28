package com.practo.jedi.dao;

import com.practo.jedi.entity.ListingEntity;
import com.practo.jedi.models.ListingFilter;

import org.springframework.data.domain.Pageable;



public interface ListingDao {

 
  public ListingEntity getListing(int id);

  public void addListing(ListingEntity listing);

  public void updateListing(ListingEntity listing);

  public void deleteListing(ListingEntity listing);

  public Iterable<ListingEntity> getListings(Pageable pageable);

  public Iterable<ListingEntity> filter(ListingFilter filter, Pageable pageable);

}
