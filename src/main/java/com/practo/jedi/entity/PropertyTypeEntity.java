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


/**
 * The persistent class for the property_type database table.
 * 
 */
@Entity
@Table(name="property_type")
@NamedQuery(name="PropertyTypeEntity.findAll", query="SELECT p FROM PropertyTypeEntity p")
public class PropertyTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on")
    private Date createdOn;

    private boolean deleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified_on")
    private Date modifiedOn;

    @Column(nullable=false, length=45)
    private String type;

    //bi-directional many-to-one association to ListingEntity
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="propertyType")
    private List<ListingEntity> listings;

    public PropertyTypeEntity() {
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

    public Date getModifiedOn() {
        return this.modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ListingEntity> getListings() {
        return this.listings;
    }

    public void setListings(List<ListingEntity> listings) {
        this.listings = listings;
    }

    public ListingEntity addListing(ListingEntity listing) {
        getListings().add(listing);
        listing.setPropertyType(this);

        return listing;
    }

    public ListingEntity removeListing(ListingEntity listing) {
        getListings().remove(listing);
        listing.setPropertyType(null);

        return listing;
    }

}