package models;

import java.sql.Date;

public class Post { 
	
	private long id;
	private String title;
	private String body; 
	private String author;
	private Date dateOfPost;
	
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(long id, String title, String body , String author) {
		super();
		this.id = id;
		this.title = title;
		this.body = body; 
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	} 
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", dateOfPost=" + dateOfPost + ", author="
				+ author + "]";
	}	  
}
