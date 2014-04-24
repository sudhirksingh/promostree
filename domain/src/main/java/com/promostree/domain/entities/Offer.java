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
	
	private int shareCount;
	private int feedBackCount;
	
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
	public Date getEndingDate() {
		return EndingDate;
	}
	public void setEndingDate(Date endingDate) {
		EndingDate = endingDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((EndingDate == null) ? 0 : EndingDate.hashCode());
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result
				+ ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + feedBackCount;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + shareCount;
		result = prime * result
				+ ((startingDate == null) ? 0 : startingDate.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result
				+ ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result
				+ ((updatedDate == null) ? 0 : updatedDate.hashCode());
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
		Offer other = (Offer) obj;
		if (EndingDate == null) {
			if (other.EndingDate != null)
				return false;
		} else if (!EndingDate.equals(other.EndingDate))
			return false;
		if (active != other.active)
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (feedBackCount != other.feedBackCount)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shareCount != other.shareCount)
			return false;
		if (startingDate == null) {
			if (other.startingDate != null)
				return false;
		} else if (!startingDate.equals(other.startingDate))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
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
		return true;
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", subject=" + subject + ", description="
				+ description + ", startingDate=" + startingDate
				+ ", EndingDate=" + EndingDate + ", shareCount=" + shareCount
				+ ", feedBackCount=" + feedBackCount + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", active=" + active
				+ ", shout=" + shout + ", venue=" + venue + "]";
	}
	
	
	

}
