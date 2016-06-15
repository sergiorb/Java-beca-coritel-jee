package com.sergiorb.loginapp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the keyword database table.
 * 
 */
@Entity
@Table(name="keyword")
@NamedQuery(name="Keyword.findAll", query="SELECT k FROM Keyword k")
public class Keyword implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String value;
	private List<Book> books;

	public Keyword() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(length=45)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	//bi-directional many-to-many association to Book
	@ManyToMany
	@JoinTable(
		name="book_has_keyword"
		, joinColumns={
			@JoinColumn(name="keyword_id", nullable=false)
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