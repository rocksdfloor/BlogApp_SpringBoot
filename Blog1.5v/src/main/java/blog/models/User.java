package models;

import java.util.HashSet;
import java.util.Set;

public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", fullName=" + fullName
				+ ", role=" + role + ", posts=" + posts + "]";
	}
	public User(Long id, String username, String passwordHash, String fullName, String role, Set<Post> posts) {
		super();
		this.id = id;
		this.username = username;
		this.passwordHash = passwordHash;
		this.fullName = fullName;
		this.role = role;
		this.posts = posts;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	private Long id;
	private String username;
	private String passwordHash;
	private String fullName;
	private String role;
	private Set<Post> posts = new HashSet<>();
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
