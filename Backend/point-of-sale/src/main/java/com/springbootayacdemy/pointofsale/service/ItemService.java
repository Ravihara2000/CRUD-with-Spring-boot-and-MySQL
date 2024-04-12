package com.springbootayacdemy.pointofsale.service;

import com.springbootayacdemy.pointofsale.dto.request.ItemSaveRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {
    String saveItem(ItemSaveRequestDto itemSaveRequestDto);
}
