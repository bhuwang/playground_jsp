/**
 * 
 */
package com.bhuwan.web.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.bhuwan.web.jsp.model.Employee;
import com.bhuwan.web.jsp.util.Role;

/**
 * Interface for {@link Employee} Object
 * 
 * @author Bhuwan Guatam <bhuwangautam@lftechnology.com>
 */
public interface EmployeeService {

    public Employee login(String username, String password) throws SQLException;

    public boolean addUser(Employee emp) throws SQLException;

    public boolean checkUserWithRole(Role role) throws SQLException;

    public void insertUserIfNotExist(Role role) throws SQLException;

    public List<Employee> getAllEmployees() throws SQLException;

    Employee constructEmployee(String username, String password, String fullname, String address, String department,
            Role role);

}
