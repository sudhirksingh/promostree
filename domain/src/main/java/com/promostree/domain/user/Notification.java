package com.promostree.domain.user;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Notification_type",discriminatorType=DiscriminatorType.STRING)

public class Notification {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		private boolean status;
		
		@Temporal(TemporalType.DATE)
		private Date createdDate;
		
		
		
		@ManyToOne
		@JoinColumn(name="userId")
		private User recipientUser;
		
		
		private String phoneNo;
		
		
		
		

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		

		public User getRecipientUser() {
			return recipientUser;
		}

		public void setRecipientUser(User recipientUser) {
			this.recipientUser = recipientUser;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		
		

	
		
		
		
}
