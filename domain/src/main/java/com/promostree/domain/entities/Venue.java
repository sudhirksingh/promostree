package com.promostree.domain.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.promostree.domain.tenant.Tenant;
import com.promostree.domain.user.UserShout;

@XmlRootElement(name = "venue")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "venue")
@Table(name = "venue")
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = " vname must filled")
	// @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid ")
	private String name;
	private String image;
	private String verified;
	private String fourSquareId;


@Transient
private double distance;


@Temporal(TemporalType.DATE)
@NotNull
private Date createdDate;

@Temporal(TemporalType.DATE)
private Date updatedDate;


@NotBlank(message = " createdBy must filled")
private String createdBy;


private String updatedBy;


private boolean active;

private int preferenceCount;
private int shoutCount;
private int shareCount;
private int feedBackCount;




@ManyToMany(mappedBy="venues",fetch = FetchType.EAGER)
@JsonBackReference
private  List<Brand> brands;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tenantId")
	private Tenant tenant;
	
	@OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = com.promostree.domain.entities.Offer.class)
	@JsonManagedReference
	private List<Offer> offers = new ArrayList<Offer>();
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "addressId")
	private Address address;
	



	
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

	public int getShareCount() {
		return shareCount;
	}

	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}

	public int getFeedBackCount() {
		return feedBackCount;
	}

	public void setFeedBackCount(int feedBackCount) {
		this.feedBackCount = feedBackCount;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((brands == null) ? 0 : brands.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + feedBackCount;
		result = prime * result
				+ ((fourSquareId == null) ? 0 : fourSquareId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((offers == null) ? 0 : offers.hashCode());
		result = prime * result + shareCount;
		result = prime * result
				+ ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result
				+ ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result
				+ ((verified == null) ? 0 : verified.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venue other = (Venue) obj;
		if (active != other.active)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (brands == null) {
			if (other.brands != null)
				return false;
		} else if (!brands.equals(other.brands))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (Double.doubleToLongBits(distance) != Double
				.doubleToLongBits(other.distance))
			return false;
		if (feedBackCount != other.feedBackCount)
			return false;
		if (fourSquareId == null) {
			if (other.fourSquareId != null)
				return false;
		} else if (!fourSquareId.equals(other.fourSquareId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (offers == null) {
			if (other.offers != null)
				return false;
		} else if (!offers.equals(other.offers))
			return false;
		if (shareCount != other.shareCount)
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (verified == null) {
			if (other.verified != null)
				return false;
		} else if (!verified.equals(other.verified))
			return false;
		return true;
	}
   
	public int getPreferenceCount() {
		return preferenceCount;
	}

	public void setPreferenceCount(int preferenceCount) {
		this.preferenceCount = preferenceCount;
	}

	public int getShoutCount() {
		return shoutCount;
	}

	public void setShoutCount(int shoutCount) {
		this.shoutCount = shoutCount;
	}

	/*@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", image=" + image
				+ ", verified=" + verified + ", fourSquareId=" + fourSquareId
				+ ", distance=" + distance + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", active=" + active
				+ ", shareCount=" + shareCount + ", feedBackCount="
				+ feedBackCount + ", brands=" + brands + ", category="
				+ category + ", tenant=" + tenant + ", offers=" + offers
				+ ", address=" + address + ", merchant=" + merchant
				+ ", userShout=" + userShout + "]";
	}*/

}