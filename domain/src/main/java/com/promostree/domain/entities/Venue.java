package com.promostree.domain.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.persistence.CascadeType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = " vname must filled")
	//@Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid ")
	private String name;

	private String image;
	private String verified;
	
	private String fourSquareId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;

	
	@OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, fetch = FetchType.EAGER,targetEntity = com.promostree.domain.entities.Offer.class)
	private List<Offer> offers = new ArrayList<Offer>();

	@OneToOne(mappedBy = "venue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Merchant merchant;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "addressId")
	private Address address;
	
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	private String createdBy;
	private String updatedBy;
	private boolean active;
	
	
	
	



	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getFourSquareId() {
		return fourSquareId;
	}

	public void setFourSquareId(String fourSquareId) {
		this.fourSquareId = fourSquareId;
	}

	
	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Venue() {
	}

	public Venue(Long id, String vname, String image, String verified) {

		this.id = id;
		this.name = vname;

		this.image = image;

		this.verified = verified;

	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

}