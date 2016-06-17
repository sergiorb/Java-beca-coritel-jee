/**
 * @file SignupUtils.java
 * @author Sergio Romero Barra
 * 
 */

package com.sergiorb.loginapp.utils;

import javax.servlet.http.HttpServletRequest;

import com.sergiorb.loginapp.daos.ReadersDao;
import com.sergiorb.loginapp.entities.Reader;


public class SignupUtils {

	
	public static Reader signup(String name, String email, String password, HttpServletRequest request) {
		
		ReadersDao dao = null;

		try {

			// Instantiates a session dao object
			dao = new ReadersDao();
			
			Reader newReader = null;
			Reader previousReader = dao.getReaderByEmail(email);
			
			if (previousReader == null) {
				
				newReader = dao.create(name, email, password);
				
				if (newReader != null) {
					return newReader;
				} else {
					request.setAttribute("signupError", true);
				}
				
			} else {
				request.setAttribute("signupError", "alreadyExist");
			}

		} catch (Exception e) {
			
			request.setAttribute("signupError", true);
			
		} finally { // In any case...

			if (dao != null) {
				dao.destroy();
			}
		}

		return null;
	}
}
