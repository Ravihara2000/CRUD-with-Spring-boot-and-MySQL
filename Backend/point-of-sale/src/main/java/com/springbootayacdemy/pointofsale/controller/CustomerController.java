package com.springbootayacdemy.pointofsale.controller;

import com.springbootayacdemy.pointofsale.dto.CustomerDto;
import com.springbootayacdemy.pointofsale.dto.request.CustomerUpdateDto;
import com.springbootayacdemy.pointofsale.service.CustomerService;
import com.springbootayacdemy.pointofsale.service.impl.CustomerServiceIMPL;
import com.springbootayacdemy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin


public class CustomerController {

    @Autowired
    private CustomerService customerService;


/*    @PostMapping("/save")
    public String save(@RequestBody CustomerDto customerDto){
        customerService.saveCustomer(customerDto);
        return "saved";
    }*/

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> save(@RequestBody CustomerDto customerDto) {
        String message = customerService.saveCustomer(customerDto);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "success", message), HttpStatus.CREATED
        );
        return response;
    }

    @PutMapping("/update")
    public String update(@RequestBody CustomerUpdateDto customerUpdateDto) {
        String messege = customerService.updateCustomer(customerUpdateDto);
        return messege + " updated";

    }

    @GetMapping(path = "/get-by-id", params = "id")
    public CustomerDto getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDto customerDto = customerService.getCustomerById(customerId);

        return customerDto;
    }

    /*    @GetMapping(path = "get-all-customers")
        public List<CustomerDto> getAllCustomers(){
            List<CustomerDto> allCustomers = customerService.getAllCustomers();
            return allCustomers;
        }*/
    @GetMapping(path = "get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDto> allCustomers = customerService.getAllCustomers();
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", allCustomers), HttpStatus.OK);
        return response;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {

        String deleted = customerService.deleteCustomer(customerId);
        return "deleted";
    }

    @GetMapping(path = "get-all-customers-by-active-state/{statues}")
    public List<CustomerDto> getAllCustomersByActiveState(@PathVariable(value = "statues") boolean activeState) {
        List<CustomerDto> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }
    @GetMapping(path = "get-customer-by-name",params = "name")
    public List<CustomerDto> getCustomersByName(@RequestParam(value = "name")String customerName){
        List <CustomerDto> customerByName=customerService.getCustomersByName(customerName);
        return customerByName;
    }

    @GetMapping(path = "get-customer-by-address",params = "address")
    public List<CustomerDto> getCustomersByAddress(@RequestParam(value = "address")String customerAddress){
        List <CustomerDto> customerByAddress=customerService.getCustomersByAddress(customerAddress);
        return customerByAddress;
    }

}
