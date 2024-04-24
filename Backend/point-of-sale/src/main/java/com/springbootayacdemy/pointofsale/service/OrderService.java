package com.springbootayacdemy.pointofsale.service;

import com.springbootayacdemy.pointofsale.dto.paginated.PaginatedResponseOrderDetails;
import com.springbootayacdemy.pointofsale.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String addOrder(RequestOrderSaveDto requestOrderSaveDto);

    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size);
}
