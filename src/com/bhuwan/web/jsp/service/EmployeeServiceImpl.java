package com.bhuwan.web.jsp.service;

import java.sql.SQLException;
import java.util.List;

import com.bhuwan.web.jsp.dao.EmployeeDao;
import com.bhuwan.web.jsp.dao.EmployeeDaoImpl;
import com.bhuwan.web.jsp.model.Employee;
import com.bhuwan.web.jsp.util.Role;

/**
 * Service layeriImplementation class for {@link Employee} Object.
 * 
 * @author Bhuwan Guatam <bhuwangautam@lftechnology.com>
 */
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public Employee login(String username, String password) throws SQLException {
        return employeeDao.login(username, password);
    }

    @Override
    public boolean addUser(Employee emp) throws SQLException {
        return employeeDao.addUser(emp);
    }

    @Override
    public boolean checkUserWithRole(Role role) throws SQLException {
        return employeeDao.checkUserWithRole(role);
    }

    @Override
    public void insertUserIfNotExist(Role role) throws SQLException {
        if (!checkUserWithRole(role)) {
            addUser(generateDefaultUser());
        }
    }

    private Employee generateDefaultUser() {
        Employee emp = new Employee();
        emp.setUsername("bhuwan");
        emp.setPassword("gautam");
        emp.setDepartment("computer");
        emp.setFullname("Bhuwan Gautam");
        emp.setRole(Role.admin);
        emp.setAddress("Pokhara");
        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee constructEmployee(String username, String password, String fullname, String address,
            String department, Role role) {
        Employee newEmp = new Employee();
        newEmp.setFullname(fullname);
        newEmp.setUsername(username);
        newEmp.setPassword(password);
        newEmp.setAddress(address);
        newEmp.setDepartment(department);
        newEmp.setRole(role);
        newEmp.setTerminated(false);
        return newEmp;
    }

}
