package com.springbootayacdemy.pointofsale.service.impl;

import com.springbootayacdemy.pointofsale.dto.CustomerDto;
import com.springbootayacdemy.pointofsale.dto.request.CustomerUpdateDto;
import com.springbootayacdemy.pointofsale.entity.Customer;
import com.springbootayacdemy.pointofsale.entity.Item;
import com.springbootayacdemy.pointofsale.exceptions.NotFoundException;
import com.springbootayacdemy.pointofsale.repo.CustomerRepo;
import com.springbootayacdemy.pointofsale.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.awt.AWTEventMulticaster.add;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveCustomer(CustomerDto customerDto) {
/*        Customer customer = new Customer(
                customerDto.getCustomerId(),
                customerDto.getCustomerName(),
                customerDto.getCustomerAddress(),
                customerDto.getSalary(),
                customerDto.getContactNumber(),
                customerDto.getNic(),
                customerDto.isActive()
        );

        customerRepo.save(customer);

        return customerDto.getCustomerName();*/
        Customer customer = modelMapper.map(customerDto,Customer.class);
        if(!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
            return customer.getCustomerName()+" saved successfully";
        }else {
            throw new DuplicateKeyException("Already added");
        }

    }
    @Override
    public String updateCustomer(CustomerUpdateDto customerUpdateDto) {
        if (customerRepo.existsById(customerUpdateDto.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDto.getCustomerId());
            customer.setCustomerName(customerUpdateDto.getCustomerName());
            customer.setCustomerAddress(customerUpdateDto.getCustomerAddress());
            customer.setSalary(customerUpdateDto.getSalary());


            customerRepo.save(customer);
            return customerUpdateDto.getCustomerName() + " updated successfully";

        } else {
            throw new RuntimeException("no data exception");
        }
    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
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

        } else {
            throw new RuntimeException("no customer");
        }

    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        if (getAllCustomers.size() > 0) {
            List<CustomerDto> customerDtoList = new ArrayList<>();

            for (Customer customer : getAllCustomers) {
                CustomerDto customerDto = new CustomerDto(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getSalary(),
                        customer.getContactNumber(),
                        customer.getNic(),
                        customer.isActive()
                );

                customerDtoList.add(customerDto);

            }
            return customerDtoList;
        } else {
            throw new NotFoundException("No Customer Found");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "deleted successfully " + customerId;
        } else {
            throw new RuntimeException("no id found");
        }

    }

    @Override
    public List<CustomerDto> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer customer : getAllCustomers) {
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );

            customerDtoList.add(customerDto);

        }
        return customerDtoList;
    }

    @Override
    public List<CustomerDto> getCustomersByName(String customerName) {
        List<Customer> getCustomerByName =customerRepo.findCustomerByCustomerName(customerName);
        if (getCustomerByName.size() > 0) {
            List<CustomerDto> customerDtoList = new ArrayList<>();

            for (Customer customer : getCustomerByName) {
                CustomerDto customerDto = new CustomerDto(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getSalary(),
                        customer.getContactNumber(),
                        customer.getNic(),
                        customer.isActive()
                );
                customerDtoList.add(customerDto);
            }

            return customerDtoList;
        }else {
            throw new RuntimeException("No customers");
        }
    }

    @Override
    public List<CustomerDto> getCustomersByAddress(String customerAddress) {
        List<Customer> getCustomerByAddress =customerRepo.getAllByCustomerAddress(customerAddress);
        if (getCustomerByAddress.size() > 0) {
            List<CustomerDto> customerDtoList = new ArrayList<>();

            for (Customer customer : getCustomerByAddress) {
                CustomerDto customerDto = new CustomerDto(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getSalary(),
                        customer.getContactNumber(),
                        customer.getNic(),
                        customer.isActive()
                );
                customerDtoList.add(customerDto);
            }

            return customerDtoList;
        }else {
            throw new RuntimeException("No customers");
        }
    }

}

