package com.bhuwan.web.jsp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhuwan.web.jsp.Address;
import com.bhuwan.web.jsp.Employee;
import com.bhuwan.web.jsp.Person;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet({ "/ELServlet", "/el" })
public class ExpressionLanguageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpressionLanguageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside ExpressionLanguageServlet#doGet Method..........");
        Person person = new Employee();
        person.setName("Bhuwan Guatam");
        request.setAttribute("person", person);

        Employee employee = new Employee();
        employee.setName("Bhuwaneshwor Guatam");
        employee.setId(101);
        Address address = new Address();
        address.setAddress("Pokhara, Nepal");
        employee.setAddress(address);

        request.getSession().setAttribute("employee", employee);

        response.addCookie(new Cookie("Person.Cookie", "Person - Bhuwan Gautam "));
        getServletContext().setAttribute("Person.Cookie", "Person - Bhuwan Gautam ");

        request.getRequestDispatcher("/el.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
    }

}
