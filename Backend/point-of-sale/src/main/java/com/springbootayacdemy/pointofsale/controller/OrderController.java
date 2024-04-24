package com.springbootayacdemy.pointofsale.controller;

import com.springbootayacdemy.pointofsale.dto.CustomerDto;
import com.springbootayacdemy.pointofsale.dto.request.ItemSaveRequestDto;
import com.springbootayacdemy.pointofsale.dto.request.RequestOrderSaveDto;
import com.springbootayacdemy.pointofsale.service.OrderService;
import com.springbootayacdemy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDto requestOrderSaveDto) {
        String id = orderService.addOrder(requestOrderSaveDto);
        System.out.println(requestOrderSaveDto);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, id+" success",id),
                HttpStatus.CREATED);
    }
}
