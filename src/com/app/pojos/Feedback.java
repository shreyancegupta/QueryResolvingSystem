package com.app.pojos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity	
@Table(name="feedbacks")
public class Feedback {

	private Integer id;
	private String name;
	private String email;
	private String feedback;
	
	public Feedback() {
		super();
	}
	
	public Feedback(String name, String email, String feedBack) {
		super();
		this.name = name;
		this.email = email;
		this.feedback = feedBack;
	}

	public Feedback(Integer id, String name, String email, String feedBack) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.feedback = feedBack;
	}

	public Feedback(Integer id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="feedback")
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedBack) {
		this.feedback = feedBack;
	}
	
	
}
