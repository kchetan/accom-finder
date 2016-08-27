package com.practo.jedi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table(name = "images")
@NamedQuery(name = "ImageEntity.findAll", query = "SELECT i FROM ImageEntity i")
public class ImageEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_on")
  private Date createdOn;

  private boolean deleted;

  @Column(name = "image_path", nullable = false, length = 100)
  private String imagePath;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modified_on")
  private Date modifiedOn;

  // bi-directional many-to-one association to ListingEntity
  @ManyToOne
  @JoinColumn(name = "listings_id", nullable = false)
  private ListingEntity listing;

  public ImageEntity() {}

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

  public String getImagePath() {
    return this.imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public Date getModifiedOn() {
    return this.modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public ListingEntity getListing() {
    return this.listing;
  }

  public void setListing(ListingEntity listing) {
    this.listing = listing;
  }

}
