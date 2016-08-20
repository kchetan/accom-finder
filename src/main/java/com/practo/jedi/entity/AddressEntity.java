package com.practo.jedi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="AddressEntity.findAll", query="SELECT a FROM AddressEntity a")
public class AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private boolean deleted;

	@Column(length=100)
	private String locality;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	@Column(name="plot_no", nullable=false, length=100)
	private String plotNo;

	@Column(name="property_name", nullable=false, length=100)
	private String propertyName;

	//bi-directional many-to-one association to ListingEntity
	@OneToMany(mappedBy="address")
	private List<ListingEntity> listings;

	public AddressEntity() {
	}

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

	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getPlotNo() {
		return this.plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public List<ListingEntity> getListings() {
		return this.listings;
	}

	public void setListings(List<ListingEntity> listings) {
		this.listings = listings;
	}

	public ListingEntity addListing(ListingEntity listing) {
		getListings().add(listing);
		listing.setAddress(this);

		return listing;
	}

	public ListingEntity removeListing(ListingEntity listing) {
		getListings().remove(listing);
		listing.setAddress(null);

		return listing;
	}

}