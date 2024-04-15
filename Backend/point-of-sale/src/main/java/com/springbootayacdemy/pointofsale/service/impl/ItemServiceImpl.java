package com.springbootayacdemy.pointofsale.service.impl;

import com.springbootayacdemy.pointofsale.config.ModelMapperConfig;
import com.springbootayacdemy.pointofsale.dto.request.ItemSaveRequestDto;
import com.springbootayacdemy.pointofsale.entity.Item;
import com.springbootayacdemy.pointofsale.repo.ItemRepo;
import com.springbootayacdemy.pointofsale.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;



@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String saveItem(ItemSaveRequestDto itemSaveRequestDto) {

        Item item = modelMapper.map(itemSaveRequestDto,Item.class);
        if(itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemName()+" saved successfully";
        }else{
            throw new DuplicateKeyException("Already added");
        }
    }
}
// Item item = modelMapper.map(itemSaveRequestDto,Item.class);
