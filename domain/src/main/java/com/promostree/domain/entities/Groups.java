package com.promostree.domain.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;




@Entity(name="groups")
@Table(name="groups")
public class Groups {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	@NotBlank(message =" group name must filled")
	private String name;
	
	@OneToMany(mappedBy="group",cascade=CascadeType.ALL)
	 @JsonManagedReference
	private List<Merchant> merchants;
	
	
	
	public List<Merchant> getMerchants() {
		return merchants;
	}
	public void setMerchants(List<Merchant> merchants) {
		this.merchants = merchants;
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
	


}
