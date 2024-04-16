package com.springbootayacdemy.pointofsale.service;

import com.springbootayacdemy.pointofsale.dto.request.ItemSaveRequestDto;
import com.springbootayacdemy.pointofsale.dto.response.ItemGetResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    String saveItem(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);
}
