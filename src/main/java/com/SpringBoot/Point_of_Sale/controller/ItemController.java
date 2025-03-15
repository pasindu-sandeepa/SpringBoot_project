package com.SpringBoot.Point_of_Sale.controller;

import com.SpringBoot.Point_of_Sale.dto.request.ItemSaveRequestDTO;
import com.SpringBoot.Point_of_Sale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(
            path = "/save"
    )
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        itemService.saveItem(itemSaveRequestDTO);
        return "saved";
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemSaveRequestDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemSaveRequestDTO> itemDTO = itemService.getItemByNameAndStatus(itemName);
        return itemDTO;
    }


}



