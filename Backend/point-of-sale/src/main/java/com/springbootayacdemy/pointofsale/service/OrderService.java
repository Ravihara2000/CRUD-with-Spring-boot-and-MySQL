package com.springbootayacdemy.pointofsale.service;

import com.springbootayacdemy.pointofsale.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String addOrder(RequestOrderSaveDto requestOrderSaveDto);
}
