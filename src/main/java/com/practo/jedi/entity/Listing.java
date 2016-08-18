package com.practo.jedi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the listings database table.
 * 
 */
@Entity
@Table(name="listings")
@NamedQuery(name="Listing.findAll", query="SELECT l FROM Listing l")
public class Listing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private float area;

	private byte deleted;

	private String furnished;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	@Column(name="no_beds")
	private int noBeds;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="possesion_date")
	private Date possesionDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="posted_on")
	private Date postedOn;

	private int price;

	@Column(name="room_for")
	private String roomFor;

	private String title;

	@Column(name="vacancy_for")
	private int vacancyFor;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="listing")
	private List<Image> images;

	//bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	//bi-directional many-to-one association to PropertyType
	@ManyToOne
	@JoinColumn(name="property_id")
	private PropertyType propertyType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="posted_by_id")
	private User user;

	public Listing() {
	}

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

	public byte getDeleted() {
		return this.deleted;
	}

	public void setDeleted(byte deleted) {
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

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setListing(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setListing(null);

		return image;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PropertyType getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}