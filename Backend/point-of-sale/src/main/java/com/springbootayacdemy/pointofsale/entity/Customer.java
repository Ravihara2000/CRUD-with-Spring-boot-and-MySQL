package com.springbootayacdemy.pointofsale.entity;


import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name="customer2")

public class Customer {
    @Id
    @Column(name="customer_id",length =45)
    @GeneratedValue(strategy = GenerationType.AUTO)//auto genrate Ids
    private int customerId;
    @Column(name="customer_name", length = 100,nullable = true)
    private String customerName;

    @Column(name="customer_address", length = 300)
    private String customerAddress;

    @Column(name="customer_salary")
    private double salary;


    @Column(name="contact_no")
    private int contactNumber;

    @Column(name="nic")
    private String nic;

    @Column(name="active_status",columnDefinition = "TINYINT default 1")
    private boolean active;

    public Customer(int customerId, String customerName, String customerAddress, double salary, int contactNumber, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.salary = salary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.active = active;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", salary=" + salary +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
