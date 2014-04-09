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

@Entity(name="target_users")
@Table(name="target_users")
public class TargetUsers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name="userId")
	@JsonManagedReference
	private User users;
	
	@ManyToOne
	@JoinColumn(name="userSharesId")
	@JsonBackReference
		private UserShares userShares;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public UserShares getUserShares() {
		return userShares;
	}

	public void setUserShares(UserShares userShares) {
		this.userShares = userShares;
	}
	
	
		
	

}
