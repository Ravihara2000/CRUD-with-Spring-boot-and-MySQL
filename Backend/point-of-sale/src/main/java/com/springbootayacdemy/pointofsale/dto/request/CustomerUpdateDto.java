package com.springbootayacdemy.pointofsale.dto.request;

public class CustomerUpdateDto {
    private int customerId;

    private String customerName;



    private String customerAddress;


    private double salary;

    public CustomerUpdateDto(int customerId, String customerName, String customerAddress, double salary) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.salary = salary;
    }
    public CustomerUpdateDto() {
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
}
