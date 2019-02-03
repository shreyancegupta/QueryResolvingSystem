package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="subjects")
public class Subject {
	
	private Integer id;
	private String name;
		
	public Subject() {
		super();
	}
	
	public Subject(Integer id) {
		super();
		this.id = id;
	}

	public Subject(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
