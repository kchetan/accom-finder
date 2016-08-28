package com.practo.jedi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;




@Entity
@Table(name = "listings")
@NamedQuery(name = "ListingEntity.findAll", query = "SELECT l FROM ListingEntity l")
public class ListingEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private float area;

  @Column(nullable = false)
  private boolean deleted;

  @Column(nullable = false, length = 50)
  private String furnished;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modified_on")
  private Date modifiedOn;

  @Column(name = "no_beds")
  private int noBeds;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "possesion_date")
  private Date possesionDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "posted_on")
  private Date postedOn;

  @Column(nullable = false)
  private int price;

  @Column(name = "room_for", length = 50)
  private String roomFor;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(name = "vacancy_for")
  private int vacancyFor;

  @LazyCollection(LazyCollectionOption.FALSE)
  // bi-directional many-to-one association to ImageEntity
  @OneToMany(mappedBy = "listing")
  private List<ImageEntity> images;

  // bi-directional many-to-one association to AddressEntity
  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToOne
  @JoinColumn(name = "address_id", nullable = false)
  private AddressEntity address;

  // bi-directional many-to-one association to PropertyTypeEntity
  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToOne
  @JoinColumn(name = "property_id", nullable = false)
  private PropertyTypeEntity propertyType;

  // bi-directional many-to-one association to UserEntity
  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToOne
  @JoinColumn(name = "posted_by_id", nullable = false)
  private UserEntity user;

  public ListingEntity() {}

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

  public boolean getDeleted() {
    return this.deleted;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public String getFurnished() {
    return this.furnished;
  }

  public void setFurnished(String furnished) {
    this.furnished = furnished;
  }

  public Date getModifiedOn() {
    return this.modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
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

  public Date getPostedOn() {
    return this.postedOn;
  }

  public void setPostedOn(Date postedOn) {
    this.postedOn = postedOn;
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

  public List<ImageEntity> getImages() {
    return this.images;
  }

  public void setImages(List<ImageEntity> images) {
    this.images = images;
  }

//  public ImageEntity addImage(ImageEntity image) {
//    getImages().add(image);
//    image.setListing(this);
//
//    return image;
//  }
//
//  public ImageEntity removeImage(ImageEntity image) {
//    getImages().remove(image);
//    image.setListing(null);
//
//    return image;
//  }

  public AddressEntity getAddress() {
    return this.address;
  }

  public void setAddress(AddressEntity address) {
    this.address = address;
  }

  public PropertyTypeEntity getPropertyType() {
    return this.propertyType;
  }

  public void setPropertyType(PropertyTypeEntity propertyType) {
    this.propertyType = propertyType;
  }

  public UserEntity getUser() {
    return this.user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

}
