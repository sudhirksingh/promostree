package com.promostree.domain.tenant;

<<<<<<< HEAD
=======
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
>>>>>>> c6a156b8f2196abec44e85f7cce61d1bec558a95
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

<<<<<<< HEAD
@XmlRootElement(name = "tenant")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
=======
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.promostree.domain.entities.Groups;
import com.promostree.domain.entities.Merchant;
import com.promostree.domain.entities.Venue;
import com.promostree.domain.user.User;


>>>>>>> c6a156b8f2196abec44e85f7cce61d1bec558a95
@Entity(name = "tenant")
@Table(name = "tenant")
public class Tenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String loginId;
	
	private String pwd;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date createdDate;
	
	private boolean active;
	
	
	@OneToMany(mappedBy="tenant",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	 @JsonManagedReference
	 @Fetch(value = FetchMode.SUBSELECT)
	private List<Merchant> merchants;
	
	@OneToMany(mappedBy="tenant",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	 @JsonManagedReference
	 @Fetch(value = FetchMode.SUBSELECT)
	private List<Venue> venues;
	
	@OneToMany(mappedBy="tenant",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	 @JsonManagedReference
	 @Fetch(value = FetchMode.SUBSELECT)
	private List<Groups> groups;
	
	@OneToMany(mappedBy="tenant",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	 @JsonManagedReference
	 @Fetch(value = FetchMode.SUBSELECT)
	private List<User> user;
	
	
	
	
	
	public List<Merchant> getMerchants() {
		return merchants;
	}
	public void setMerchants(List<Merchant> merchants) {
		this.merchants = merchants;
	}
	public List<Venue> getVenues() {
		return venues;
	}
	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}
	public List<Groups> getGroups() {
		return groups;
	}
	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
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
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	
	
	
	
	

	
}