package com.sergiorb.loginapp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reader database table.
 * 
 */
@Entity
@Table(name="reader")
@NamedQueries({
	@NamedQuery(name="Reader.findAll", query="SELECT r FROM Reader r"),
	@NamedQuery(name="Reader.getByName", query="SELECT r FROM Reader r WHERE r.userName = :userName"),
	@NamedQuery(name="Reader.getByEmail", query="SELECT r FROM Reader r WHERE r.email = :email"),
	@NamedQuery(name="Reader.getByEmailAndPass", query="SELECT r FROM Reader r WHERE r.email = :email AND r.password = :password")
})
public class Reader implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String password;
	private String userName;
	private String websiteUrl;
	private List<Book> books;

	public Reader() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(length=255)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(length=45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(name="user_name", length=45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Column(name="website_url", length=255)
	public String getWebsiteUrl() {
		return this.websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}


	//bi-directional many-to-many association to Book
	@ManyToMany
	@JoinTable(
		name="book_has_reader"
		, joinColumns={
			@JoinColumn(name="reader_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="book_id", nullable=false)
			}
		)
	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}