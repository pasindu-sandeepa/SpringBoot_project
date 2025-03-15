package com.SpringBoot.Point_of_Sale.service;

import com.SpringBoot.Point_of_Sale.dto.request.ItemSaveRequestDTO;

import java.util.List;

public interface ItemService {


    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemSaveRequestDTO> getItemByNameAndStatus(String itemName);



}
