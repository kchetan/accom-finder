package com.practo.jedi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String email;

  private String mobile;

  private String name;

  public User(String email, String name) {
    super();
    this.email = email;
    this.name = name;
  }

  // bi-directional many-to-one association to Listing
  @OneToMany(mappedBy = "user")
  private List<Listing> listings;

  public User() {}

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return this.mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Listing> getListings() {
    return this.listings;
  }

  public void setListings(List<Listing> listings) {
    this.listings = listings;
  }

  public Listing addListing(Listing listing) {
    getListings().add(listing);
    listing.setUser(this);

    return listing;
  }

  public Listing removeListing(Listing listing) {
    getListings().remove(listing);
    listing.setUser(null);

    return listing;
  }

}
