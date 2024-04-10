package com.springbootayacdemy.pointofsale.service.impl;

import com.springbootayacdemy.pointofsale.dto.CustomerDto;
import com.springbootayacdemy.pointofsale.dto.request.CustomerUpdateDto;
import com.springbootayacdemy.pointofsale.entity.Customer;
import com.springbootayacdemy.pointofsale.repo.CustomerRepo;
import com.springbootayacdemy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService{
@Autowired
private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        Customer customer =new Customer(
        customerDto.getCustomerId(),
        customerDto.getCustomerName(),
        customerDto.getCustomerAddress(),
        customerDto.getSalary(),
        customerDto.getContactNumber(),
        customerDto.getNic(),
        customerDto.isActive()
        );

        customerRepo.save(customer);

        return customerDto.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDto customerUpdateDto) {
        if(customerRepo.existsById(customerUpdateDto.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDto.getCustomerId());
            customer.setCustomerName(customerUpdateDto.getCustomerName());
            customer.setCustomerAddress(customerUpdateDto.getCustomerAddress());
            customer.setSalary(customerUpdateDto.getSalary());


            customerRepo.save(customer);
            return customerUpdateDto.getCustomerName()+" updated successfully";

        }else {
            throw new RuntimeException("no data exception");
        }
    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer=customerRepo.getReferenceById(customerId);
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDto;

        }else {
            throw new RuntimeException("no customer");
        }

    }
}

