/**
 * @file SessionsDao.java
 * @author Sergio Romero Barra
 *
 *	Implements session dao.
 */

package com.sergiorb.loginapp.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sergiorb.loginapp.config.AppConfig;
import com.sergiorb.loginapp.entities.Reader;
import com.sergiorb.loginapp.entities.Session;


public class SessionsDao implements GenericDaoInterface, SessionsDaoInterface {

	// JPA (DB access) objects.
	private EntityManagerFactory emfactory;
	private EntityManager entitymanager;

	public SessionsDao() {
		this.init();
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
	 * Retrieves a session object searching by session and login string.
	 */
	@Override
	public Session getBySessionAndLogin(String sessionString, String loginString) {

		Session session;

		try {

			// Executes named query
			session = this.getEntitymanager().createNamedQuery("Session.getBySessionAndLogin", Session.class)
					.setParameter("session", sessionString).setParameter("login", loginString).getSingleResult();

		} catch (Exception e) {

			return null;
		}

		return session;
	}
	
	/**
	 * Creates a new session object that link it with a reader object.
	 */
	@Override
	public Session create(String sessionString, String loginString, Reader reader) {

		Session session;

		try {

			// Creates a transaction
			this.getEntitymanager().getTransaction().begin();

			// Create a new session
			session = new Session(sessionString, loginString, reader);
			
			// Stores session in DB.
			this.getEntitymanager().persist(session);

			// Executes commit.
			this.getEntitymanager().getTransaction().commit();

		} catch (Exception e) {

			return null;
		}

		return session;
	}

	/**
	 * Deletes a session object
	 */
	@Override
	public boolean delete(String sessionString, String loginString) {

		Session session;

		try {

			// Transaction begin...
			this.getEntitymanager().getTransaction().begin();

			// Executes named query
			session = this.getEntitymanager().createNamedQuery("Session.getBySessionAndLogin", Session.class)
					.setParameter("session", sessionString).setParameter("login", loginString).getSingleResult();
			
			// if session exists...
			if(session != null) {
				
				// Deletes session
				this.getEntitymanager().remove(session);
				
				// Finish transaction.
				this.getEntitymanager().getTransaction().commit();
				
				return true;
			}
		} catch (Exception e) {
			// TODO:
		}

		return false;
	}
}
