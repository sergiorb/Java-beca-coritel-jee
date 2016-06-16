package com.sergiorb.loginapp.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sergiorb.loginapp.config.AppConfig;
import com.sergiorb.loginapp.utils.SessionUtils;

/**
 * Servlet implementation class Dashboard
 */

public class DashboardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// If session is logged...
		if(SessionUtils.isLogged(request)) {
			
			// Pass to current request the current reader object.
			request.setAttribute("reader", SessionUtils.getReader(request));
			
			// Renders dashboard to request.
			request.getRequestDispatcher(AppConfig.TEMPATE_PATH + "dashboard/dashboard.jsp").forward(request, response);
			
		} else {
			
			// Redirects to login.
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login"));
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
