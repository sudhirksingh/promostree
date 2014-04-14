package com.promostree.domain.user;

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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity(name = "target_user")
@Table(name = "target_user")
public class TargetUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "userId")
	@JsonManagedReference
	private User user;

	@ManyToOne
	@JoinColumn(name = "userSharesId")
	@JsonBackReference
	private UserShare userShares;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUsers() {
		return user;
	}

	public void setUsers(User users) {
		this.user = users;
	}

	public UserShare getUserShares() {
		return userShares;
	}

	public void setUserShares(UserShare userShares) {
		this.userShares = userShares;
	}

}
