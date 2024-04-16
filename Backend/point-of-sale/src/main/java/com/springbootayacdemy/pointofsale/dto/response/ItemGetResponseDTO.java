package com.springbootayacdemy.pointofsale.dto.response;

import com.springbootayacdemy.pointofsale.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemGetResponseDTO {

    private int itemId;

    private String itemName;


    private double balanceQty;


    private double supplierPrice;


    private double sellingPrice;

    private boolean activeState;

}
