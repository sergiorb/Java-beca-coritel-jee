/**
 * @file SessionUtils
 * @author Sergio Romero Barra
 * 
 */

package com.sergiorb.loginapp.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sergiorb.loginapp.config.AppConfig;
import com.sergiorb.loginapp.daos.SessionsDao;
import com.sergiorb.loginapp.entities.Reader;
import com.sergiorb.loginapp.entities.Session;

public class SessionUtils {

	/**
	 * @param request
	 * @param reader
	 * @return true if a new session is created.
	 */
	public static boolean login(HttpServletRequest request, Reader reader) {

		SessionsDao dao = null;

		try {

			// Instantiates a session dao object
			dao = new SessionsDao();

			// Creates a session object from request.
			HttpSession sessionRequest = request.getSession();
			
			// Generates a new session ID
			String loginHash = SessionIdentifierGenerator.newSessionId();

			// Creates a session in the DB 
			Session sessionDB = dao.create(sessionRequest.getId(), loginHash, reader);

			
			if (sessionDB != null) {
				
				// Sets login hash on sessionRequest
				sessionRequest.setAttribute(AppConfig.LOGINHASH_STRING, loginHash);
				
				// Sets logged attribute on session request.
				sessionRequest.setAttribute(AppConfig.LOGGED_STRING, true);
				
				return true;
			}

		} catch (Exception e) {
			// TODO: complete exception body.
		} finally { // In any case...

			if (dao != null) {
				dao.destroy();
			}
		}

		return false;
	}

	/**
	 * @param request
	 * @return true is session is deleted successfully.
	 */
	public static boolean logout(HttpServletRequest request) {

		SessionsDao dao = null;

		try {

			// Creates a session object from request.
			HttpSession session = request.getSession();

			// Instantiates a session dao object
			dao = new SessionsDao();

			// Deletes session from the DB and returns true if success.
			Boolean success = dao.delete(session.getId(), (String) session.getAttribute(AppConfig.LOGINHASH_STRING));

			if (success) {
				
				// Invalidate session
				session.invalidate();
				return true;
			}

		} catch (Exception e) {
			// TODO: complete exception body.
		} finally { // In any case...


			if (dao != null) {
				dao.destroy();
			}
		}

		return false;
	}

	/**
	 * 
	 * @param request
	 * @return true if request session is logged.
	 */
	public static boolean isLogged(HttpServletRequest request) {

		SessionsDao dao = null;

		try {

			// Instantiates a session dao object
			dao = new SessionsDao();

			// Creates a session object from request.
			HttpSession sessionRequest = request.getSession();

			// Searchs session in the DB
			Session sessionDB = dao.getBySessionAndLogin(sessionRequest.getId(),
					(String) sessionRequest.getAttribute(AppConfig.LOGINHASH_STRING));

			if (sessionDB != null) {
				return true;
			}

		} catch (Exception e) {
			// TODO: complete exception body.
		} finally { // In any case...

			if (dao != null) {
				dao.destroy();
			}
		}

		return false;
	}

	/**
	 * 
	 * @param request
	 * @return Returns a reader object from a session request if it's logged.
	 */
	public static Reader getReader(HttpServletRequest request) {

		SessionsDao dao = null;
		Reader reader = null;

		try {

			// Instantiates a session dao object
			dao = new SessionsDao();

			// Creates a session object from request.
			HttpSession sessionRequest = request.getSession();

			// Retrieves session from request.
			Session session = dao.getBySessionAndLogin(sessionRequest.getId(),
					(String) sessionRequest.getAttribute(AppConfig.LOGINHASH_STRING));

			// If session exists, return associated reader
			if (session != null) {
				return session.getReader();
			}

		} catch (Exception e) {
			// TODO: complete exception body.
		} finally {

			if (dao != null) {
				dao.destroy();
			}
		}

		return reader;
	}
}
