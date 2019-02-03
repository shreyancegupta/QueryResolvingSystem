package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {
	private Integer id;
	private String name;
	private String email;
	private String password;
	
	private List<Reply> replies=new ArrayList<Reply>();
	
	public Student() {
		super();
	}
	
	public Student(Integer id) {
		super();
		this.id = id;
	}

	public Student(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public Student(Integer id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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
	
	@Column(length=35)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
//	@Column(length=35)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy="student",cascade=CascadeType.ALL,fetch=FetchType.EAGER /*,cascade=CascadeType.REMOVE, orphanRemoval=true*/)
	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
//	@PreRemove
//	private void preRemove() {
//		for(Reply r : replies)
//			r.setStudent(null);
//	}
	
	
}
