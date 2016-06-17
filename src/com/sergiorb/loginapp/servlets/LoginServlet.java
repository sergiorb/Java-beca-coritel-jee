package com.sergiorb.loginapp.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sergiorb.loginapp.config.AppConfig;
import com.sergiorb.loginapp.daos.ReadersDao;
import com.sergiorb.loginapp.entities.Reader;
import com.sergiorb.loginapp.utils.SessionUtils;
import com.sergiorb.loginapp.utils.Validators;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// If request is logged..
		if(SessionUtils.isLogged(request)) {
			
			// Redirects to dashboard.
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
			return;
			
		} else {

			// Renders login page.
			request.getRequestDispatcher(AppConfig.TEMPATE_PATH + "/login/login.jsp").forward(request, response);
		}
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
		if (Validators.checkEmail(email) && Validators.checkPassword(password)) {

			// Retrieves reader object
			Reader reader = this.getReaderDao().getReaderByEmailAndPass(email, password);
			
			// If reader exist in database...
			if(reader != null && reader.getEmail().equals(email) && reader.getPassword().equals(password)) {
				
				// Logs in the request
				if(SessionUtils.login(request, reader)) {
					
					// Redirects request to dashboard
					response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
					return;
				} else {
					// TODO: add message. request.setAttribute("message", "Error!");
				}
			}
		} 

		// Sets error on request
		request.setAttribute("error", true);
		// Responses error template.
		request.getRequestDispatcher(AppConfig.TEMPATE_PATH + "/login/login.jsp").forward(request, response);
	}
}
