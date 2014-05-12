package com.promostree.domain.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name="brand")
@Table(name="brand")
public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Long id;
	private  String name;
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date createdDate;
	private boolean active;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="venues_brands",
	inverseJoinColumns={@JoinColumn(name="venue_id", referencedColumnName="id")},
	joinColumns={@JoinColumn(name="brand_id", referencedColumnName="id")}
	)
	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	private  List<Venue> venues;
	
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
	public List<Venue> getVenues() {
		return venues;
	}
	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((venues == null) ? 0 : venues.hashCode());
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
		Brand other = (Brand) obj;
		if (active != other.active)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (venues == null) {
			if (other.venues != null)
				return false;
		} else if (!venues.equals(other.venues))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", createdDate="
				+ createdDate + ", active=" + active + ", venues=" + venues
				+ "]";
	}
	
	
	
}
