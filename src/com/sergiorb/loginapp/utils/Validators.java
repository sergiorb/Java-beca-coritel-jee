/**
 * @author Sergio Romero Barra
 *
 */

package com.sergiorb.loginapp.utils;

import javax.servlet.http.HttpServletRequest;

public class Validators {

	/**
	 * @param email.
	 *            Asserts given email string is a valid email.
	 */
	public static boolean checkName(String name) {

		if (name != null) {
			if (!name.equals("")) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param email.
	 *            Asserts given email string is a valid email.
	 */
	public static boolean checkEmail(String email) {

		if (email != null) {
			if (!email.equals("")) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param password.
	 *            Asserts given password string is a valid password.
	 */
	public static boolean checkPassword(String password) {

		if (password != null) {
			if (!password.equals("")) {
				return true;
			}
		}

		return false;
	}

	public static boolean checkPasswords(String password1, String password2) {

		if (!Validators.checkPassword(password1)) {
			return false;
		}

		if (!Validators.checkPassword(password2)) {
			return false;
		}

		if (!password1.equals(password2)) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isSignupFormValid(String name, String email, String password, String password2) {

		if (!Validators.checkName(name)) {
			return false;
		}

		if (!Validators.checkName(email)) {
			return false;
		}

		if (!Validators.checkName(password)) {
			return false;
		}

		if (!Validators.checkName(password2)) {
			return false;
		}

		if (!Validators.checkPasswords(password, password2)) {
			return false;
		}

		return true;
	}

	public static HttpServletRequest addSignupErrorsToRequest(HttpServletRequest request) {

		if (!Validators.checkName(request.getParameter("name"))) {
			request.setAttribute("nameError", true);
		}

		if (!Validators.checkName(request.getParameter("email"))) {
			request.setAttribute("emailError", true);
		}

		if (!Validators.checkName(request.getParameter("password"))) {
			request.setAttribute("passwordError", true);
		}

		if (!Validators.checkName(request.getParameter("password2"))) {
			request.setAttribute("passwordError2", true);
		}

		if (!Validators.checkPasswords(request.getParameter("password"), request.getParameter("password2"))) {
			request.setAttribute("passwordError2", "notEqual");
		}

		return request;
	}

}
