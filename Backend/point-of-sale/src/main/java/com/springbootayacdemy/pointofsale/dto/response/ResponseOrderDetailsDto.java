package com.springbootayacdemy.pointofsale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseOrderDetailsDto {
    //customer
    private String customerName;
    private String customerAddress;
    private ArrayList contactNumber;

    //order
    private Date date;
    private Double total;

}
