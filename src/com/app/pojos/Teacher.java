package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="teachers")
public class Teacher {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String subject;

	private List<Reply> replies=new ArrayList<Reply>();
	
	public Teacher() {
		super();
	}
	
	public Teacher(Integer id) {
		super();
		this.id = id;
	}

	public Teacher(String name, String email, String password, String subject) {
		super();
		this.name = name;
		this.password = password;
		this.subject = subject;
	}
	public Teacher(Integer id, String name, String email, String password, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.subject = subject;
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
	
//	@Column(length=35)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy="student",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", subject="
				+ subject + "]";
	}
	
}
