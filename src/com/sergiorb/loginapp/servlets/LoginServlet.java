package com.sergiorb.loginapp.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sergiorb.loginapp.daos.ReadersDao;
import com.sergiorb.loginapp.entities.Reader;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ReadersDao readerDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the readerDao
	 */
	public ReadersDao getReaderDao() {
		return readerDao;
	}

	/**
	 * @param readerDao the readerDao to set
	 */
	public void setReaderDao(ReadersDao readerDao) {
		this.readerDao = readerDao;
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.setReaderDao(new ReadersDao());		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		this.getReaderDao().destroy();
	}
	
	/** @param email. 
	 * Asserts given email string is 
	 * a valid email. 
	 */
	private boolean checkEmail(String email) {

		if (email != null) {
			if (!email.equals("")) {
				return true;
			}
		}

		return false;
	}
	
	/** @param password. 
	 * Asserts given password string is 
	 * a valid password. 
	 */
	private boolean checkPassword(String password) {

		if (password != null) {
			if (!password.equals("")) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/Templates/login/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Gets forms data
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// If they are valid...
		if (this.checkEmail(email) && this.checkPassword(password)) {

			Reader reader = this.getReaderDao().getReaderByEmailAndPass(email, password);
			
			//System.out.println(reader.toString());
			
			if(reader != null && reader.getEmail() == email && reader.getPassword() == password) {
				
				// TODO: login process
				
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
			}
		} 

		// If validation fails, returns to login:
		// Controls if the login was successful or not.
		request.setAttribute("validLogin", false);
		// Responses error template.
		request.getRequestDispatcher("/Templates/login/login.jsp").forward(request, response);
	}
}
