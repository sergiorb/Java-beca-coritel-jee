package com.sergiorb.loginapp.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sessions
 *
 */
@Entity
@Table(name="sessions")
@NamedQueries({
	@NamedQuery(name="Session.getBySessionAndLogin", 
			query="SELECT r FROM Session r WHERE r.sessionString = :session AND r.loginString = :login")
})
public class Session implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String sessionString;
	private String loginString;
	private Reader reader;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the sessionString
	 */
	public String getSessionString() {
		return sessionString;
	}

	/**
	 * @param sessionString the sessionString to set
	 */
	public void setSessionString(String sessionString) {
		this.sessionString = sessionString;
	}

	
	/**
	 * @return the loginString
	 */
	public String getLoginString() {
		return loginString;
	}

	/**
	 * @param loginString the loginString to set
	 */
	public void setLoginString(String loginString) {
		this.loginString = loginString;
	}

	/**
	 * @return the reader
	 */
	@OneToOne()
	@JoinColumn(name="reader_id")
	public Reader getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Session() {
		super();
	}

	public Session(String sessionString, String loginString, Reader reader) {
		super();
		this.setSessionString(sessionString);
		this.setLoginString(loginString);
		this.setReader(reader);
	}
}
