/**
 * @author Sergio Romero Barra
 *
 */

package com.sergiorb.loginapp.daos;

import java.util.List;

import com.sergiorb.loginapp.entities.Reader;

public interface ReadersDaoInterface {

	abstract List<Reader> getAllreaders();
	abstract Reader getReaderByName(String name);
	abstract Reader getReaderByEmail(String email);
	abstract Reader getReaderByEmailAndPass(String email, String password);
}
