package com.practo.jedi.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table(name="images")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="image_path")
	private String imagePath;

	//bi-directional many-to-one association to Listing
	@ManyToOne
	@JoinColumn(name="listings_id")
	private Listing listing;

	public Image() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

}