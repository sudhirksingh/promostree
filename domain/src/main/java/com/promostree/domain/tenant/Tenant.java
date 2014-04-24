package com.promostree.domain.tenant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "tenant")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "tenant")
@Table(name = "tenant")
public class Tenant {
	@XmlElement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@XmlElement
	private String name;
	@XmlElement
	private String loginId;
	@XmlElement
	private String pwd;
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
	
	
	
	
	

	
}