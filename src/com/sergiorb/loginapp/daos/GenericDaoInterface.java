/**
 * @author Sergio Romero Barra
 *
 */

package com.sergiorb.loginapp.daos;


public interface GenericDaoInterface {

		public static final String PERSISTENCE_UNIT = "Java_beca_coritel_loginapp";
		
		abstract void init();
		abstract void destroy();
}
