package com.bhuwan.web.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhuwan.web.jsp.db.DBConnection;
import com.bhuwan.web.jsp.model.Employee;
import com.bhuwan.web.jsp.util.Role;

/**
 * Implementation class for {@link Employee} DAO interface.
 * 
 * @author Bhuwan Guatam <bhuwangautam@lftechnology.com>
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Employee login(String username, String password) throws SQLException {
        ResultSet rs = null;
        String sql = "select * from user where username=? and password=? and isTerminated=false";
        Connection con = DBConnection.getJNDIConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        rs = stmt.executeQuery();
        Employee emp = null;
        while (rs.next()) {
            emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setFullname(rs.getString("fullname"));
            emp.setUsername(rs.getString("username"));
            emp.setPassword(rs.getString("password"));
            emp.setTermintaed(rs.getBoolean("isTerminated"));
            emp.setAddress(rs.getString("address"));
            emp.setDepartment(rs.getString("department"));
            emp.setRole(Role.valueOf(rs.getString("role")));
        }
        return emp;
    }

    @Override
    public boolean addUser(Employee emp) throws SQLException {
        String sql = "insert into user(username, password, fullname, address, department, role) values(?,?,?,?,?,?)";
        Connection con = DBConnection.getJNDIConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, emp.getUsername());
        stmt.setString(2, emp.getPassword());
        stmt.setString(3, emp.getFullname());
        stmt.setString(4, emp.getAddress());
        stmt.setString(5, emp.getDepartment());
        stmt.setString(6, emp.getRole().toString());
        return stmt.execute();
    }

    @Override
    public boolean checkUserWithRole(Role role) throws SQLException {
        String sql = "select * from user where role=?";
        Connection con = DBConnection.getJNDIConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, role.toString());
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        String sql = "select * from user";
        Connection con = DBConnection.getJNDIConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        Employee emp = null;
        List<Employee> empList = new ArrayList<Employee>();
        while (rs.next()) {
            emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setFullname(rs.getString("fullname"));
            emp.setUsername(rs.getString("username"));
            emp.setPassword(rs.getString("password"));
            emp.setTermintaed(rs.getBoolean("isTerminated"));
            emp.setAddress(rs.getString("address"));
            emp.setDepartment(rs.getString("department"));
            emp.setRole(Role.valueOf(rs.getString("role")));
            emp.setTerminated(Boolean.valueOf(rs.getString("isTerminated")));
            empList.add(emp);
        }
        System.out.println("empList:: "+empList.size());
        return empList;
    }
}
