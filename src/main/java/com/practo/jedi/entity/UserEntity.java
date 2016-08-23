package com.practo.jedi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_on", nullable = false, length = 19)
  private Date createdOn;

  @Column(columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private boolean deleted = true;

  @Column(nullable = false, length = 100)
  private String email;

  @Column(length = 45)
  private String mobile;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modified_on")
  private Date modifiedOn;

  @Column(nullable = false, length = 100)
  private String name;

  // bi-directional many-to-one association to ListingEntity
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "user")
  private List<ListingEntity> listings;

  public UserEntity() {}

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getCreatedOn() {
    return this.createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public boolean getDeleted() {
    return this.deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
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

  public Date getModifiedOn() {
    return this.modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<ListingEntity> getListings() {
    return this.listings;
  }

  public void setListings(List<ListingEntity> listings) {
    this.listings = listings;
  }

  public ListingEntity addListing(ListingEntity listing) {
    getListings().add(listing);
    listing.setUser(this);

    return listing;
  }

  public ListingEntity removeListing(ListingEntity listing) {
    getListings().remove(listing);
    listing.setUser(null);

    return listing;
  }

}
