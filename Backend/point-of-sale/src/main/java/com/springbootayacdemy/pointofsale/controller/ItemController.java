package com.springbootayacdemy.pointofsale.controller;

import com.springbootayacdemy.pointofsale.dto.request.ItemSaveRequestDto;
import com.springbootayacdemy.pointofsale.dto.response.ItemGetResponseDTO;
import com.springbootayacdemy.pointofsale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin

public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public String saveItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto){
        String messege=itemService.saveItem(itemSaveRequestDto);
        return messege+" saved";
    }

    @GetMapping(path = "/get-by-name",params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name")String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;
    }

    @GetMapping(path = "/get-by-name-with-mapstruct",params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam(value = "name")String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatusByMapstruct(itemName);
        return itemDTOS;
    }

}

