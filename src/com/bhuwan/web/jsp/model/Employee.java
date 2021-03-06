package com.bhuwan.web.jsp.model;

import com.bhuwan.web.jsp.util.Role;

/**
 * POJO class for {@link Employee} object
 * 
 * @author Bhuwan Guatam <bhuwangautam@lftechnology.com>
 */
public class Employee extends User {
    private String fullname;
    private String address;
    private String department;
    private Role role;
    private boolean terminated;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return the terminated
     */
    public boolean isTerminated() {
        return terminated;
    }

    /**
     * @param terminated
     *            the terminated to set
     */
    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

}
