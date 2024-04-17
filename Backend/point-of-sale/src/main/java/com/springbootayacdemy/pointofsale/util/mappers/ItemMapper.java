package com.springbootayacdemy.pointofsale.util.mappers;

import com.springbootayacdemy.pointofsale.dto.response.ItemGetResponseDTO;
import com.springbootayacdemy.pointofsale.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

@Mapper(componentModel = "spring")
public interface ItemMapper {
    //itemList ----> ItemResponseDto
    List<ItemGetResponseDTO> entityListToDtoList( List<Item> items);
}
