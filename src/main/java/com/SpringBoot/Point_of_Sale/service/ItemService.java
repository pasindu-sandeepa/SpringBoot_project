package com.SpringBoot.Point_of_Sale.service;

import com.SpringBoot.Point_of_Sale.dto.request.ItemSaveRequestDTO;

public interface ItemService {


    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);
}
