package com.springbootayacdemy.pointofsale.service;

import com.springbootayacdemy.pointofsale.dto.CustomerDto;
import com.springbootayacdemy.pointofsale.dto.request.CustomerUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public String saveCustomer(CustomerDto customerDto);

    public String updateCustomer(CustomerUpdateDto customerUpdateDto);

    CustomerDto getCustomerById(int customerId);

    List<CustomerDto> getAllCustomers();

    String deleteCustomer(int customerId);
}
