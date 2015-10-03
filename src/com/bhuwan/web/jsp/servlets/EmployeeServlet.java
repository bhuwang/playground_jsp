package com.bhuwan.web.jsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bhuwan.web.jsp.model.Employee;
import com.bhuwan.web.jsp.service.EmployeeService;
import com.bhuwan.web.jsp.service.EmployeeServiceImpl;
import com.bhuwan.web.jsp.util.Role;

/**
 * Servlet implementation class Employee
 * 
 * @author Bhuwan Guatam <bhuwangautam@lftechnology.com>
 */
@WebServlet(description = "Employee Management Application", urlPatterns = { "/employee", "*.do" }, initParams = { @WebInitParam(name = "admin-email", value = "pawaladhikari@lftechnology.com") }, loadOnStartup = 1)
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class.getName());

    public static final String HTML_START = "<html><body>";
    public static final String HTML_END = "</body></html>";
    EmployeeService service = new EmployeeServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Inside EmployeeServlet#doGet method...Remote Address: {}", request.getRemoteAddr());

        try {
            request.setAttribute("empList", service.getAllEmployees());
        }
        catch (SQLException e) {
            LOGGER.error("Inside EmployeeServlet#doGet method.. {}", e);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/emp_list.jsp");
        rd.include(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        LOGGER.info("Inside EmployeeServlet#doPost method...Remote Address: {}", request.getRemoteAddr());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        Role role = Role.valueOf(request.getParameter("role"));
        String department = request.getParameter("department");
        String address = request.getParameter("address");

        Employee emp = service.constructEmployee(username, password, fullname, address, department, role);
        try {
            service.addUser(emp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println("<div><font color=green>New employee added successfully.</font></div>");
        RequestDispatcher rd = request.getRequestDispatcher("/add.jsp");
        rd.include(request, response);
    }

}
