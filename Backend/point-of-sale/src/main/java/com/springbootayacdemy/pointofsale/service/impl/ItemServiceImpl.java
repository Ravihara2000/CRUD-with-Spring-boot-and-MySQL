package com.springbootayacdemy.pointofsale.service.impl;

import com.springbootayacdemy.pointofsale.dto.request.ItemSaveRequestDto;
import com.springbootayacdemy.pointofsale.entity.Customer;
import com.springbootayacdemy.pointofsale.entity.Item;
import com.springbootayacdemy.pointofsale.repo.ItemRepo;
import com.springbootayacdemy.pointofsale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Override
    public String saveItem(ItemSaveRequestDto itemSaveRequestDto) {
        Item item = new Item(
                1,
                itemSaveRequestDto.getItemName(),
                itemSaveRequestDto.getMeasuringUnitType(),
                itemSaveRequestDto.getBalanceQty(),
                itemSaveRequestDto.getSupplierPrice(),
                itemSaveRequestDto.getSellingPrice(),
                true
                );

        itemRepo.save(item);

        return itemSaveRequestDto.getItemName();
    }
}
