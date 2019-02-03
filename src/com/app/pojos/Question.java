package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Question {
	
	private Integer id;
	private String heading;
	private String data;
	private Date date;
	private String subject;
	
	private int studentId;
	private boolean closed;
	
	private List<Reply> replies=new ArrayList<Reply>();

	
	public Question() {
		super();
	}
	public Question(String heading, String data, Date date, String subject, int studentId) {
		super();
		this.heading = heading;
		this.data = data;
		this.date = date;
		this.subject = subject;
		this.studentId = studentId;
		
	}
	public Question(Integer id, String heading, String data, Date date, String subject, int studentId) {
		super();
		this.id = id;
		this.heading = heading;
		this.data = data;
		this.date = date;
		this.subject = subject;
		this.studentId = studentId;
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(length=140)
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
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
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL,fetch=FetchType.EAGER)//fetch=FetchType.EAGER
	public List<Reply> getReplies() {
		return replies;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	
	//add convenience methods in POJO layer --in case of bi-directional relationship
	public void addReply(Reply r)
	{
		replies.add(r);
		r.setQuestion(this);
	}
	public void removeReply(Reply r)
	{
		replies.remove(r);
		r.setQuestion(null);
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", heading=" + heading + ", data=" + data + ", date=" + date + ", subject="
				+ subject + ", studentId=" + studentId + ", closed=" + closed + "]";
	}
	
	

}
