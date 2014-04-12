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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;
@Component
@Entity(name = "user_shares")
@Table(name = "user_shares")
public class UserShares {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonBackReference
	private User user;

	private String comment;
	@Temporal(TemporalType.DATE)
	private Date createDate;

	private String value;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "typeId")
	@JsonBackReference
	private Type type;

	@OneToMany(mappedBy = "userShares", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	@Fetch(value = FetchMode.SUBSELECT)
	private List<TargetUser> targetUsers;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<TargetUser> getTargetUsers() {
		return targetUsers;
	}

	public void setTargetUsers(List<TargetUser> targetUsers) {
		this.targetUsers = targetUsers;
	}

}