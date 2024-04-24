package com.springbootayacdemy.pointofsale.service.impl;

import com.springbootayacdemy.pointofsale.dto.paginated.PaginatedResponseOrderDetails;
import com.springbootayacdemy.pointofsale.dto.queryinterface.OrderDetailInterface;
import com.springbootayacdemy.pointofsale.dto.request.RequestOrderDetailSave;
import com.springbootayacdemy.pointofsale.dto.request.RequestOrderSaveDto;
import com.springbootayacdemy.pointofsale.dto.response.ItemGetResponseDTO;
import com.springbootayacdemy.pointofsale.dto.response.ResponseOrderDetailsDto;
import com.springbootayacdemy.pointofsale.entity.Order;
import com.springbootayacdemy.pointofsale.entity.OrderDetails;
import com.springbootayacdemy.pointofsale.repo.CustomerRepo;
import com.springbootayacdemy.pointofsale.repo.ItemRepo;
import com.springbootayacdemy.pointofsale.repo.OrderDetailRepo;
import com.springbootayacdemy.pointofsale.repo.OrderRepo;
import com.springbootayacdemy.pointofsale.service.OrderService;
import com.springbootayacdemy.pointofsale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ItemRepo itemRepo;


    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDto requestOrderSaveDto) {
        Order order = new Order(
                customerRepo.getById(requestOrderSaveDto.getCustomers()),
                requestOrderSaveDto.getDate(),
                requestOrderSaveDto.getTotal()
        );

        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())) {
            List<OrderDetails> orderDetails = modelMapper.
                    map(requestOrderSaveDto.getOrderDetails(), new TypeToken<List<OrderDetails>>() {
                    }.getType());
            for (int i = 0; i < orderDetails.size(); i++) {
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDto.getOrderDetails().get(i).getItems()));
            }
            if (orderDetails.size() > 0) {
                orderDetailRepo.saveAll(orderDetails);
            }
            return "order saved";
        }
        return null;

    }

    @Override
    public PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size) {
        List<OrderDetailInterface> orderDetailsDTOS = orderRepo.getAllOrderDetails(status, PageRequest.of(page,size));

        List<ResponseOrderDetailsDto> list = new ArrayList<>();
        for(OrderDetailInterface o: orderDetailsDTOS){
            ResponseOrderDetailsDto r = new ResponseOrderDetailsDto(
                    o.getCustomerName(),
                    o.getCustomerAddress(),
                    o.getContactNumber(),
                    o.getDate(),
                    o.getTotal()

            );
            list.add(r);
        }

        PaginatedResponseOrderDetails paginatedResponseOrderDetails = new PaginatedResponseOrderDetails(
                list,

                orderRepo.countAllOrderDetails(status)
        );
        return paginatedResponseOrderDetails;
    }
}
