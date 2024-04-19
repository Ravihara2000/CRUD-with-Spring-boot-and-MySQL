package com.springbootayacdemy.pointofsale.service.impl;

import com.springbootayacdemy.pointofsale.config.ModelMapperConfig;
import com.springbootayacdemy.pointofsale.dto.paginated.PaginatedResponseItemDTO;
import com.springbootayacdemy.pointofsale.dto.request.ItemSaveRequestDto;
import com.springbootayacdemy.pointofsale.dto.response.ItemGetResponseDTO;
import com.springbootayacdemy.pointofsale.entity.Customer;
import com.springbootayacdemy.pointofsale.entity.Item;
import com.springbootayacdemy.pointofsale.entity.enums.MeasuringUnitType;
import com.springbootayacdemy.pointofsale.exceptions.NotFoundException;
import com.springbootayacdemy.pointofsale.repo.ItemRepo;
import com.springbootayacdemy.pointofsale.service.ItemService;
import com.springbootayacdemy.pointofsale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public String saveItem(ItemSaveRequestDto itemSaveRequestDto) {

       Item item = modelMapper.map(itemSaveRequestDto,Item.class);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemName()+" saved successfully";
        }else{
            throw new DuplicateKeyException("Already added");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean b =true;


        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);
        if(items.size()>0){
            List<ItemGetResponseDTO>itemGetResponseDTOS = itemMapper.entityListToDtoList(items);

            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("not active");
        }

    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName) {
        boolean b =true;


        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);
        if(items.size()>0){
            //convert a list
            //type token in java
            //map a list using model mapper
            List<ItemGetResponseDTO>itemGetResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType() );
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("not active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByActiveStatus(boolean activeStatus) {
        return null;
    }

    @Override
    public PaginatedResponseItemDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page,size));
        int count=itemRepo.countAllByActiveStateEquals(activeStatus);
        if(items.getSize()<1){
            throw new NotFoundException("No Data");
        }
        PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                itemMapper.ListDtoToPage(items),
                count
        );

        return paginatedResponseItemDTO;
    }


}

