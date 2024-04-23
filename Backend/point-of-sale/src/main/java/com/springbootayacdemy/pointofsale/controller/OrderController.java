package com.springbootayacdemy.pointofsale.controller;

import com.springbootayacdemy.pointofsale.dto.CustomerDto;
import com.springbootayacdemy.pointofsale.dto.request.ItemSaveRequestDto;
import com.springbootayacdemy.pointofsale.dto.request.RequestOrderSaveDto;
import com.springbootayacdemy.pointofsale.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin

public class OrderController {

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDto requestOrderSaveDto) {
        System.out.println(requestOrderSaveDto);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, 2+"success",2),
                HttpStatus.CREATED);
    }
}
