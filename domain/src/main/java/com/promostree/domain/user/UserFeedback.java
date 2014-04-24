package com.promostree.domain.user;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "user_feedback")
@Table(name = "user_feedback")
public class UserFeedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String comment;
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	private Long value;

@ManyToOne
@JoinColumn(name="userId")
@JsonBackReference(value="user-userFeedback")
private User user;
	@OneToOne
	@JoinColumn(name = "typeId")
	@JsonManagedReference
	private Type type;

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}
@OneToMany(mappedBy = "userFeedback",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JsonBackReference
@Fetch(value = FetchMode.SUBSELECT)
private List<Notification> notifications;


	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
public List<Notification> getNotifications() {
	return notifications;
}

public void setNotifications(List<Notification> notifications) {
	this.notifications = notifications;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((comment == null) ? 0 : comment.hashCode());
	result = prime * result
			+ ((createdDate == null) ? 0 : createdDate.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	/*result = prime * result
			+ ((notifications == null) ? 0 : notifications.hashCode());*/
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	result = prime * result
			+ ((updatedDate == null) ? 0 : updatedDate.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
	result = prime * result + ((value == null) ? 0 : value.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) 
{
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	UserFeedback other = (UserFeedback) obj;
	if (comment == null) {
		if (other.comment != null)
			return false;
	} else if (!comment.equals(other.comment))
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
	/*if (notifications == null) {
		if (other.notifications != null)
			return false;
	} else if (!notifications.equals(other.notifications))
		return false;*/
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	if (updatedDate == null) {
		if (other.updatedDate != null)
			return false;
	} else if (!updatedDate.equals(other.updatedDate))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	if (value == null) {
		if (other.value != null)
			return false;
	} else if (!value.equals(other.value))
		return false;
	return true;
}

/*@Override
public String toString() {
	return "UserFeedback [id=" + id + ", comment=" + comment + ", createdDate="
			+ createdDate + ", updatedDate=" + updatedDate + ", value=" + value
			+ ", user=" + user + ", type=" + type + ", notifications="
			+ notifications + "]";
}

*/


}