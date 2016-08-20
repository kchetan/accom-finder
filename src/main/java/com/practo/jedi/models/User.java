package com.practo.jedi.models;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import com.practo.jedi.entity.ListingEntity;
import com.practo.jedi.entity.UserEntity;

public class User {
  private String name;
  private String email;
  private String mobile;
  private int id;
  private List<ListingEntity> listings;

  @Transient
  public List<ListingEntity> getListings() {
    return listings;
  }

  public List<Integer> getListingsId() {
    List<ListingEntity> listings = getListings();
    List<Integer> ListingIds = new ArrayList<Integer>();
    for (ListingEntity each : listings) {
      ListingIds.add(each.getId());
    }
    return ListingIds;
  }

  public void setListings(List<ListingEntity> listings) {
    this.listings = listings;
  }

  public User() {}

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public User(String name, String email, String mobile) {
    this.name = name;
    this.email = email;
    this.mobile = mobile;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  @Override
  public String toString() {
    return "User [name=" + name + ", email=" + email + "]";
  }

  public UserEntity EntityObj() {
    System.out.println("came get");
    UserEntity et = new UserEntity();
    et.setEmail(getEmail());
    et.setName(getName());
    et.setMobile(getMobile());
    if (new Integer(getId()) != null)
      et.setId(getId());
    return et;
  }

  public void mergeEntity(UserEntity e) {

    if (e != null) {
      setName(e.getName());
      setEmail(e.getEmail());
      setMobile(e.getMobile());
      setListings(e.getListings());
      setId(e.getId());
      // System.out.println("end merge");
    }
  }
}