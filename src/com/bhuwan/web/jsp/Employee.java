/**
 * 
 */
package com.bhuwan.web.jsp;

/**
 * @author bhuwan
 */
public class Employee extends Person {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;

    @Override
    public String toString() {
        return "ID=" + id + ", Name=" + name + ", Address=" + address;
    }
}
