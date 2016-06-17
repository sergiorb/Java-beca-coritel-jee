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
import com.sergiorb.loginapp.utils.SignupUtils;
import com.sergiorb.loginapp.utils.Validators;

/**
 * Servlet implementation class SignupServlet
 */

public class SignupServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ReadersDao readerDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(AppConfig.TEMPATE_PATH + "/signup/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");

		if(Validators.isSignupFormValid(name, email, password, password2)) {
			
			Reader reader = SignupUtils.signup(name, email, password, request);
			
			if(reader != null) {
				
				request.setAttribute("reader", reader);
				request.getRequestDispatcher(AppConfig.TEMPATE_PATH + "/signup/success.jsp").forward(request, response);
				return;
			}
			
		} else {
			Validators.addSignupErrorsToRequest(request);
		}
		doGet(request, response);
	}

}
