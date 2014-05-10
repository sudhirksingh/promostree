package com.promostree.domain.user;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "notification")
@Table(name = "notification")
public class Notification {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@Temporal(TemporalType.DATE)
		@NotNull
		private Date createdDate;
		
		@ManyToOne
		@JoinColumn(name="userId")
		private User user;
		
		@ManyToOne
		@JoinColumn(name="eventTypeId")
		private EventType eventType;
		
		
	
		
		@ManyToOne
		@JoinColumn(name = "userShareId")
		@JsonManagedReference
		private UserShare userShare;
		
		
		@ManyToOne
		@JoinColumn(name = "userFeedbackId")
		@JsonManagedReference
		private UserFeedback userFeedback;
		

		public UserShare getUserShare() {
			return userShare;
		}

		public void setUserShare(UserShare userShare) {
			this.userShare = userShare;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public EventType getEventType() {
			return eventType;
		}

		public void setEventType(EventType eventType) {
			this.eventType = eventType;
		}

		public UserFeedback getUserFeedback() {
			return userFeedback;
		}

		public void setUserFeedback(UserFeedback userFeedback) {
			this.userFeedback = userFeedback;
		}
		
		
		
}
