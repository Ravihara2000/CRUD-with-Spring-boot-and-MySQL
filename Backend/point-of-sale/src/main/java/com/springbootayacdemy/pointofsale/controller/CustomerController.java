package com.springbootayacdemy.pointofsale.controller;

import com.springbootayacdemy.pointofsale.dto.CustomerDto;
import com.springbootayacdemy.pointofsale.dto.request.CustomerUpdateDto;
import com.springbootayacdemy.pointofsale.service.CustomerService;
import com.springbootayacdemy.pointofsale.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CustomerDto getCustomerById(int customerId){

        return null;
    }

}
