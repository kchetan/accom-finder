package com.practo.jedi.dao;

import java.util.List;

import com.practo.jedi.entity.ListingEntity;

public interface ListingDao {

  public ListingEntity getListing(int id);

  public void addListing(ListingEntity listing);

  public void updateListing(ListingEntity listing);

  public void deleteListing(ListingEntity listing);

  public List<ListingEntity> getListings();

}
