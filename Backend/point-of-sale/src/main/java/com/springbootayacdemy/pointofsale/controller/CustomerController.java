package com.springbootayacdemy.pointofsale.controller;

import com.springbootayacdemy.pointofsale.dto.CustomerDto;
import com.springbootayacdemy.pointofsale.dto.request.CustomerUpdateDto;
import com.springbootayacdemy.pointofsale.service.CustomerService;
import com.springbootayacdemy.pointofsale.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin


public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/save")
    public String save(@RequestBody CustomerDto customerDto){
        customerService.saveCustomer(customerDto);
        return "saved";
    }

    @PutMapping("/update")
    public String update(@RequestBody CustomerUpdateDto customerUpdateDto){
        String messege =customerService.updateCustomer(customerUpdateDto);
        return messege+" updated";

    }
    @GetMapping(path = "/get-by-id",params = "id")
    public CustomerDto getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDto customerDto = customerService.getCustomerById(customerId);

        return customerDto;
    }

    @GetMapping(path = "get-all-customers")
    public List<CustomerDto> getAllCustomers(){
        List<CustomerDto> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){

        String deleted = customerService.deleteCustomer(customerId);
        return "deleted";
    }

}
