package com.practo.jedi.models;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.practo.jedi.entity.AddressEntity;
import com.practo.jedi.entity.ImageEntity;
import com.practo.jedi.entity.ListingEntity;
import com.practo.jedi.entity.PropertyTypeEntity;
import com.practo.jedi.entity.UserEntity;

public class Listing {
  private int id;
  private float area;
  private String furnished;
  private int noBeds;
  private Date possesionDate;
  private int price;
  private String roomFor;
  private String title;
  private int vacancyFor;
  private int postedById;
  private int addressId;
  private int propertyId;
  private Date postedOn;


  public Date getPostedOn() {
    return postedOn;
  }

  public void setPostedOn(Date postedOn) {
    this.postedOn = postedOn;
  }

  // private UserEntity user;
  private UserEntity user;

  @Transient
  public UserEntity getUser() {
    return user;
  }

  private PropertyTypeEntity propertyType;

  private AddressEntity address;

  private List<ImageEntity> images;

  @Transient
  public List<ImageEntity> getImages() {
    if (this.images != null) {
      return this.images;
    } else
      return new ArrayList<ImageEntity>();
  }

  public void setImages(List<ImageEntity> images) {
    this.images = images;
  }

  // @Transient
  public List<Integer> getimagesId() {
    List<ImageEntity> images = getImages();
    List<Integer> imageIds = new ArrayList<Integer>();
    for (ImageEntity each : images) {
      imageIds.add(each.getId());
    }
    return imageIds;
  }

  public Listing() {}

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public float getArea() {
    return this.area;
  }

  public void setArea(float area) {
    this.area = area;
  }

  public String getFurnished() {
    return this.furnished;
  }

  public void setFurnished(String furnished) {
    this.furnished = furnished;
  }

  public int getNoBeds() {
    return this.noBeds;
  }

  public void setNoBeds(int noBeds) {
    this.noBeds = noBeds;
  }

  public Date getPossesionDate() {
    return this.possesionDate;
  }

  public void setPossesionDate(Date possesionDate) {
    this.possesionDate = possesionDate;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getRoomFor() {
    return this.roomFor;
  }

  public void setRoomFor(String roomFor) {
    this.roomFor = roomFor;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getVacancyFor() {
    return this.vacancyFor;
  }

  public void setVacancyFor(int vacancyFor) {
    this.vacancyFor = vacancyFor;
  }

  @Override
  public String toString() {
    return "Listing";
  }

  public int getPostedById() {
    if (this.user != null) {
      return this.user.getId();
    } else {

      return this.postedById;
    }
  }

  @Transient
  public AddressEntity getAddress() {
    return this.address;
  }

  public int getAddressId() {
    if (this.address != null) {
      return this.address.getId();
    } else {
      return this.addressId;
    }
  }

  @Transient
  public PropertyTypeEntity getPropertyType() {
    return this.propertyType;
  }

  public int getPropertyId() {
    if (this.propertyType != null)
      return this.propertyType.getId();
    else {
      return this.propertyId;
    }
  }

  public void setPostedById(int userId) {
    this.postedById = userId;
  }

  @Transient
  public String getUserName() {
    return this.user.getName();
  }


  public void setUser(UserEntity user) {
    this.user = user;
  }

  public void setAddress(AddressEntity address) {
    this.address = address;
  }

  public void setPropertyType(PropertyTypeEntity pType) {
    this.propertyType = pType;
  }

  @Transactional
  public ListingEntity EntityObj() {
    ListingEntity et = new ListingEntity();
    et.setArea(getArea());
    et.setFurnished(getFurnished());
    et.setNoBeds(getNoBeds());
    et.setPossesionDate(getPossesionDate());
    et.setPrice(getPrice());
    et.setRoomFor(getRoomFor());
    et.setTitle(getTitle());
    et.setVacancyFor(getVacancyFor());
    et.setImages(getImages());
    if (new Integer(getId()) != null)
      et.setId(getId());
    return et;
  }

  @Transactional
  public void mergeEntity(ListingEntity e) {
    if (e != null) {
      setArea(e.getArea());
      setFurnished(e.getFurnished());
      setNoBeds(e.getNoBeds());
      setPossesionDate(e.getPossesionDate());
      setPrice(e.getPrice());
      setRoomFor(e.getRoomFor());
      setTitle(e.getTitle());
      setVacancyFor(e.getVacancyFor());
      setId(e.getId());
      setUser(e.getUser());
      setAddress(e.getAddress());
      setPropertyType(e.getPropertyType());
      setImages(e.getImages());
      setPostedOn(e.getPostedOn());
    }
  }

  @Transactional
  public ListingEntity updateEntity(ListingEntity e) {
    if (getArea() != 0) {
      e.setArea(getArea());
    }
    if (getFurnished() != null) {
      e.setFurnished(getFurnished());
    }
    if (getNoBeds() != 0) {
      e.setNoBeds(getNoBeds());
    }
    if (getPossesionDate() != null) {
      e.setPossesionDate(getPossesionDate());
    }
    if (getPrice() != 0) {
      e.setPrice(getPrice());
    }
    if (getRoomFor() != null) {
      e.setRoomFor(getRoomFor());
    }
    if (getTitle() != null) {
      e.setTitle(getTitle());
    }
    if (getVacancyFor() != 0) {
      e.setVacancyFor(getVacancyFor());
    }
    if (getImages() != null) {
      e.setImages(getImages());
    }
    e.setId(getId());
    return e;
  }
}
