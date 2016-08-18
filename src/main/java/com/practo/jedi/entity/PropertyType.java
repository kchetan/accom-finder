package com.practo.jedi.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the property_type database table.
 * 
 */
@Entity
@Table(name="property_type")
@NamedQuery(name="PropertyType.findAll", query="SELECT p FROM PropertyType p")
public class PropertyType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String type;

	//bi-directional many-to-one association to Listing
	@OneToMany(mappedBy="propertyType")
	private List<Listing> listings;

	public PropertyType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Listing> getListings() {
		return this.listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}

	public Listing addListing(Listing listing) {
		getListings().add(listing);
		listing.setPropertyType(this);

		return listing;
	}

	public Listing removeListing(Listing listing) {
		getListings().remove(listing);
		listing.setPropertyType(null);

		return listing;
	}

}