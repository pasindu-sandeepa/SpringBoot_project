package com.SpringBoot.Point_of_Sale.service.impl;

import com.SpringBoot.Point_of_Sale.dto.request.ItemSaveRequestDTO;
import com.SpringBoot.Point_of_Sale.entity.Item;
import com.SpringBoot.Point_of_Sale.repo.ItemRepo;
import com.SpringBoot.Point_of_Sale.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Save Item
    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return item.getItemId() + " saved successfully";
        } else {
            throw new DuplicateKeyException("Already Exist");
        }
    }

    // Get all items by name and status
    @Override
    public List<ItemSaveRequestDTO> getItemByNameAndStatus(String itemName) {
        boolean activeState = true;
        List<Item> items = itemRepo.findAllByItemNameAndActiveState(itemName, activeState);
        if (items.size() > 0) {
            return modelMapper.map(items, new TypeToken<List<ItemSaveRequestDTO>>(){}.getType());
        } else {
            throw new RuntimeException("No Item Found");
        }
    }


}