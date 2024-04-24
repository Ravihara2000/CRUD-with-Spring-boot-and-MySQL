package com.springbootayacdemy.pointofsale.dto.queryinterface;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailInterface {

    //type methods
    String getCustomerName();

    String getCustomerAddress();

    ArrayList getContactNumber();

    Date getDate();

    Double getTotal();



}
