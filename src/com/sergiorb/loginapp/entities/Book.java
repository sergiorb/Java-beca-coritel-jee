package com.sergiorb.loginapp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@Table(name="book")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String isbn_10;
	private String link;
	private String name;
	private int pagesCount;
	private String price;
	private List<Author> authors;
	private List<Keyword> keywords;
	private List<Reader> readers;

	public Book() {
	}


	@Id
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="`ISBN-10`", length=45)
	public String getIsbn_10() {
		return this.isbn_10;
	}

	public void setIsbn_10(String isbn_10) {
		this.isbn_10 = isbn_10;
	}


	@Column(length=255)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	@Column(length=255)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="pages_count")
	public int getPagesCount() {
		return this.pagesCount;
	}

	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}


	@Column(length=45)
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	//bi-directional many-to-many association to Author
	@ManyToMany
	@JoinTable(
		name="book_has_author"
		, joinColumns={
			@JoinColumn(name="book_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="author_id", nullable=false)
			}
		)
	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


	//bi-directional many-to-many association to Keyword
	@ManyToMany(mappedBy="books")
	public List<Keyword> getKeywords() {
		return this.keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}


	//bi-directional many-to-many association to Reader
	@ManyToMany(mappedBy="books")
	public List<Reader> getReaders() {
		return this.readers;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}

}