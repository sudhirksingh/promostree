package com.promostree.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

<<<<<<< HEAD
@Entity(name = "event_type")
@Table(name = "event_type")
public class EventType {
=======
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;





@Entity(name="event_type")
@Table(name="event_type")
public class EventType
{
>>>>>>> c6a156b8f2196abec44e85f7cce61d1bec558a95

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
<<<<<<< HEAD

	@OneToOne(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private UserEvent userEvent;

=======
	
	@OneToOne
	@JsonIgnore
	private UserEvent userEvent;
	

@OneToOne(mappedBy="eventType",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JsonBackReference
	private Notification notification;
	
	
>>>>>>> c6a156b8f2196abec44e85f7cce61d1bec558a95
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

	public UserEvent getUserEvent() {
		return userEvent;
	}

	public void setUserEvent(UserEvent userEvent) {
		this.userEvent = userEvent;
	}
<<<<<<< HEAD
=======

	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		/*result = prime * result
				+ ((notification == null) ? 0 : notification.hashCode());*/
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
		EventType other = (EventType) obj;
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
		/*if (notification == null) {
			if (other.notification != null)
				return false;
		} else if (!notification.equals(other.notification))
			return false;*/
		return true;
	}
	/*@Override
	public String toString() {
		return "EventType [id=" + id + ", name=" + name + ", userEvent=" + userEvent + ", notification=" + notification + "]";
	}*/
	
	
	
	
	
	
	
	
	
	
>>>>>>> c6a156b8f2196abec44e85f7cce61d1bec558a95

}