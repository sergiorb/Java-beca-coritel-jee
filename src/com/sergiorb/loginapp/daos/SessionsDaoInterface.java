/**
 * 
 * @file SessionsDaoInterface.java
 * @author Sergio Romero Barra
 * 
 * Defines session dao.
 * 
 */

package com.sergiorb.loginapp.daos;

import com.sergiorb.loginapp.entities.Reader;
import com.sergiorb.loginapp.entities.Session;

public interface SessionsDaoInterface {

	abstract Session getBySessionAndLogin(String sessionString, String loginString);
	abstract Session create(String sessionString, String loginString, Reader reader);
	abstract boolean delete(String sessionString, String loginString);
}
