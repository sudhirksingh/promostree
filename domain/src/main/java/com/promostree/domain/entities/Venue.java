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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.persistence.CascadeType;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;
@XmlRootElement(name="venue")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="venue")
@Table(name="venue")
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long id;

	@NotBlank(message = " vname must filled")
	@XmlElement
	//@Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid ")
	private String name;
@XmlElement
	private String image;
@XmlElement
	private String verified;
@XmlElement
	private String fourSquareId;

@Transient
private double distance;


@Temporal(TemporalType.DATE)
@NotNull
@XmlElement
private Date createdDate;

@Temporal(TemporalType.DATE)
@XmlElement
private Date updatedDate;


@NotBlank(message = " createdBy must filled")
@XmlElement
private String createdBy;

@XmlElement
private String updatedBy;

@XmlElement
private boolean active;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	@XmlElement
	private Category category;

	
	@OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, fetch = FetchType.EAGER,targetEntity = com.promostree.domain.entities.Offer.class)
	@XmlElement
	@JsonManagedReference
	private List<Offer> offers = new ArrayList<Offer>();

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "addressId")
	@XmlElement
	private Address address;
	
	@OneToOne(mappedBy = "venue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@XmlElement
	  @JsonManagedReference
	private Merchant merchant;

	
	
	
	


	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

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