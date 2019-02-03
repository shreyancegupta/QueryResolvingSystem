package com.app.pojos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

 

@Entity
@Table(name="admins")
public class Admin {
	private Integer id;
	private String password;
	private String name;
	
	public Admin() {
		super();
	}
	public Admin(Integer id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=35)
	@NotNull
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
