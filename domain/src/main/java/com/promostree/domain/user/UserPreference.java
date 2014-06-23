package com.promostree.domain.user;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity(name = "user_preference")
@Table(name = "user_preference")
public class UserPreference {

	public UserPreference() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPreference(Long id, Type type, Date createdDate, Long value,
			User user) {
		super();
		this.id = id;
		this.type = type;
		this.createdDate = createdDate;
		this.value = value;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "typeId")
	private Type type;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	private Long value;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		UserPreference other = (UserPreference) obj;
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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

	/*
	 * @Override public String toString() { return "UserPreference [id=" + id +
	 * ", type=" + type + ", createdDate=" + createdDate + ", value=" + value +
	 * ", user=" + user + "]"; }
	 */


	public String getJson(Object userPreference) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_DEFAULT);
		return mapper.writeValueAsString(userPreference);
	}

	@Override
	public String toString() {
		return "UserPreference [id=" + id + ", createdDate=" + createdDate
				+ ", value=" + value + "]";
	}




}