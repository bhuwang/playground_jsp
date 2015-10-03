package com.bhuwan.web.jsp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class Logout
 * 
 * @author Bhuwan Guatam <bhuwangautam@lftechnology.com>
 */
@WebServlet(name = "LogoutServlet", urlPatterns = { "/LogoutServlet", "/logout", "/signout" })
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LogManager.getLogger(LogoutServlet.class.getName());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Inside LogoutServlet#doGet method..uri: {}", request.getRequestURI());
        process(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        LOGGER.info("Inside LogoutServlet#doPost method..uri: {}", request.getRequestURI());
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("Inside LogoutServlet#process method..uri: {}", request.getRequestURI());
        response.setContentType("text/html");
        // Using HttpSession
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println("JSESSIONID=" + cookie.getValue());
                    break;
                }
            }
        }
        // invalidate the session if exists
        HttpSession session = request.getSession(false);
        LOGGER.debug("User= {}", session.getAttribute("user"));
        if (session != null) {
            session.invalidate();
        }

        // no url encoding because session has been invalidated already
        response.sendRedirect("login.jsp");
    }

}
