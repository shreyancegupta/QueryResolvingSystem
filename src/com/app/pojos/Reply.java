package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="replies")
public class Reply {

	private Integer id;
	private String data;
	private Date date;
	
	private Student student;
	private Teacher teacher;
	private Question question;
	
	public Reply() {
		super();
	}
	public Reply(String data, Date date) {
		super();
		this.data = data;
		this.date = date;
		
	}
	public Reply(Integer id, String data, Date date) {
		super();
		this.id = id;
		this.data = data;
		this.date = date;
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	//@OneToOne(cascade=CascadeType.PERSIST)
	//@ForeignKey() DEPRICATED
	@ManyToOne/*(cascade=CascadeType.ALL)*/
	@JoinColumn(name="sid")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne/*(cascade=CascadeType.ALL)*/
	@JoinColumn(name="tid")
	public Teacher getTeacher() {
			return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@ManyToOne/*(cascade=CascadeType.ALL)*/
	@JoinColumn(name="qid")
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	//remove if not required
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reply other = (Reply) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Reply [id=" + id + ", data=" + data + ", date=" + date + ", student=" + student + ", teacher=" + teacher
				+ ", question=" + question + "]";
	}
	
	//Convenience method
	public void removeStudent() {
		this.student=null;
	}
}
