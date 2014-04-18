package com.promostree.domain.user;

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
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonBackReference;





@Entity(name="event_type")
@Table(name="event_type")
public class EventType
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
	private String name;
	
	@OneToOne(mappedBy="type",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private UserEvent userEvent;
	
	
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
	
	
	
	
	
	
	
	
	
	

}