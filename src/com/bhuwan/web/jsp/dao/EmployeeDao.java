package com.bhuwan.web.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.bhuwan.web.jsp.model.Employee;
import com.bhuwan.web.jsp.util.Role;


/**
 * Interface for {@link Employee} object.
 * 
 * @author Bhuwan Guatam <bhuwangautam@lftechnology.com>
 */
public interface EmployeeDao {
    public Employee login(String username, String password) throws SQLException;

    public boolean addUser(Employee emp) throws SQLException;

    public boolean checkUserWithRole(Role role) throws SQLException;

    public List<Employee> getAllEmployees() throws SQLException;
}
