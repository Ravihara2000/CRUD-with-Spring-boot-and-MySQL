package com.springbootayacdemy.pointofsale.service;

import com.springbootayacdemy.pointofsale.dto.paginated.PaginatedResponseItemDTO;
import com.springbootayacdemy.pointofsale.dto.request.ItemSaveRequestDto;
import com.springbootayacdemy.pointofsale.dto.response.ItemGetResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    String saveItem(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName);

    List<ItemGetResponseDTO> getItemByActiveStatus(boolean activeStatus);

    PaginatedResponseItemDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size);
}
