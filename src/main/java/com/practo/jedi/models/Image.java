package com.practo.jedi.models;

import java.beans.Transient;

import javax.transaction.Transactional;

import com.practo.jedi.entity.ImageEntity;
import com.practo.jedi.entity.ListingEntity;
import com.practo.jedi.entity.UserEntity;

public class Image {
  private String imagePath;
  
  private int id;
  private int listingId;
  private ListingEntity listing;
  
  @Transient
  public ListingEntity getListing() {
    return listing;
  }

  public void setListing(ListingEntity listing) {
    this.listing = listing;
  }

  public int getlistingId() {
    if (this.listing != null) {
      return this.listing.getId();
    } else {
      return this.listingId;
    }
  }


  public void setListingId(int listingId) {
    this.listingId = listingId;
  }

  public Image() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  @Override
  public String toString() {
    return "Image [path=" + imagePath + "]";
  }

  @Transactional
  public ImageEntity entityObj() {
    // System.out.println("came get");
    ImageEntity et = new ImageEntity();
    et.setImagePath(getImagePath());
    et.setListing(getListing());
    if (new Integer(getId()) != null) {
      et.setId(getId());
    }
    return et;
  }

  @Transactional
  public void mergeEntity(ImageEntity e) {
    if (e != null) {
      setImagePath(e.getImagePath());
      setId(e.getId());
      setListing(e.getListing());
      // System.out.println("end merge");
    }
  }

  @Transactional
  public ImageEntity updateEntity(ImageEntity et) {
    et.setImagePath(getImagePath());
    et.setId(getId());
    if (getListing() != null) {
      et.setListing(getListing());
    }
    return et;
  }
}
