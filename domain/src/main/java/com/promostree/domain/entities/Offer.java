package com.promostree.domain.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity(name="offer")
@Table(name="offer")
public class Offer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	 @NotBlank(message =" offer subject must filled")
    private String subject;
	private String description;

	@Temporal(TemporalType.DATE)
	private Date startingDate;
	
	@Temporal(TemporalType.DATE)
	private Date EndingDate;
	
	 @NotNull
		@Temporal(TemporalType.DATE)
		private Date createdDate;
		@Temporal(TemporalType.DATE)
		private Date updatedDate;
		
		@NotBlank(message = "offer createdBy must filled")
		private String createdBy;
		private String updatedBy;
		private boolean active;
		
		  @JsonManagedReference
		 @OneToOne(mappedBy="offer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
			private Shout shout;
		
	 	
	 @ManyToOne
	@JoinColumn(name="venueId",referencedColumnName="id",insertable=true, updatable=true,nullable=true)
	 @JsonBackReference
	private Venue venue;
	
	 
	
	
	 

	

	public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
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
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Shout getShout() {
		return shout;
	}
	public void setShout(Shout shout) {
		this.shout = shout;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getEndingDate() {
		return EndingDate;
	}
	public void setEndingDate(Date endingDate) {
		EndingDate = endingDate;
	}
	
	
	

}
