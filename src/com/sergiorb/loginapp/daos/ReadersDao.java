/**
 * @file ReadersDao.java
 * @author Sergio Romero Barra
 * 
 * Implements readers dao.
 */

package com.sergiorb.loginapp.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import com.sergiorb.loginapp.config.AppConfig;
import com.sergiorb.loginapp.entities.Reader;


public class ReadersDao implements GenericDaoInterface, ReadersDaoInterface {

	// JPA (DB access) objects.
	private EntityManagerFactory emfactory;
	private EntityManager entitymanager;

	public ReadersDao() {
		this.init(); // Initiates JPA access
	}

	/**
	 * @return the emfactory
	 */
	public EntityManagerFactory getEmfactory() {
		return emfactory;
	}

	/**
	 * @param emfactory
	 *            the emfactory to set
	 */
	public void setEmfactory(EntityManagerFactory emfactory) {
		this.emfactory = emfactory;
	}

	/**
	 * @return the entitymanager
	 */
	public EntityManager getEntitymanager() {
		return entitymanager;
	}

	/**
	 * @param entitymanager
	 *            the entitymanager to set
	 */
	public void setEntitymanager(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sergiorb.loginapp.daos.GenericDaoInterface#init()
	 */
	@Override
	public void init() {
		
		// Instantiates JPA access objects.
		this.setEmfactory(Persistence.createEntityManagerFactory(AppConfig.PERSISTENCE_UNIT));
		this.setEntitymanager(this.getEmfactory().createEntityManager());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sergiorb.loginapp.daos.GenericDaoInterface#destroy()
	 */
	@Override
	public void destroy() {
		
		// Close JPA access objects.
		this.getEntitymanager().close();
		this.getEmfactory().close();
	}
	
	/**
	 * Retrieves all readers in the database.
	 */
	@Override
	public List<Reader> getAllreaders() {
		
		List<Reader> readers;
		
		try {
			
			readers = this.getEntitymanager()
				.createNamedQuery("Reader.findAll", Reader.class)
				.getResultList(); // Calls the named query defined on Reader entity.
			
		} catch (Exception e) {
			
			return null;
		}
		
		return readers;
	}

	/**
	 *  Retrieves a reader object searching by name
	 */
	@Override
	public Reader getReaderByName(String name) {
		
		Reader reader;
		
		try {
			
			reader = this.getEntitymanager()
				.createNamedQuery("Reader.getByName", Reader.class)
				.setParameter("userName", name)
				.getSingleResult(); // Calls the named query defined on Reader entity.
			
		} catch (Exception e) {
			
			return null;
		}
		
		return reader;
	}

	/**
	 *  Retrieves a reader object searching by email
	 */
	@Override
	public Reader getReaderByEmail(String email) {
		
		Reader reader;
		
		try {
			
			reader = this.getEntitymanager()
					.createNamedQuery("Reader.getByEmail", Reader.class )
					.setParameter("email", email)
					.getSingleResult();
			
		} catch (Exception e) {
			
			return null;
		}
		
		return reader;
	}

	/**
	 *  Retrieves a reader object searching by its email and its password
	 */
	@Override
	public Reader getReaderByEmailAndPass(String email, String password) {
		
		Reader reader;
		
		try {
		
			reader = this.getEntitymanager()
					.createNamedQuery("Reader.getByEmailAndPass", Reader.class)
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
			
		} catch (NoResultException e) {
			
			return null;
		}
		
		return reader;
	}
}
