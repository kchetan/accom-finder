package com.practo.jedi.models;

import java.beans.Transient;
import java.util.Date;

import com.practo.jedi.entity.AddressEntity;
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
  

  //private UserEntity user;
  private UserEntity user;
  
  private PropertyTypeEntity propertyType;
  
  private AddressEntity address;

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
    if (this.user != null)
    return this.user.getId();
    else{
      System.out.println(this.postedById + " -------");
      return this.postedById;
    }
  }
  
  public int getAddressId() {
    if (this.address != null)
    return this.address.getId();
    else{
      return this.addressId;
    }
  }
  public int getPropertyId() {
    if (this.propertyType != null)
    return this.propertyType.getId();
    else{
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
    if (new Integer(getId()) != null)
      et.setId(getId());
    return et;
  }

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
    }
  }
}
