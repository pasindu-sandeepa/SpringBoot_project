package com.SpringBoot.Point_of_Sale.service.impl;

import com.SpringBoot.Point_of_Sale.dto.paginated.PaginatedResponseItemDTO;
import com.SpringBoot.Point_of_Sale.dto.request.ItemSaveRequestDTO;
import com.SpringBoot.Point_of_Sale.entity.Item;
import com.SpringBoot.Point_of_Sale.entity.enums.MeasuringUnitType;
import com.SpringBoot.Point_of_Sale.repo.ItemRepo;
import com.SpringBoot.Point_of_Sale.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        if (!itemRepo.existsById(item.getItemId())) { // Ensure itemId is set properly
            itemRepo.save(item);
            return "Item ID: " + item.getItemId() + " saved successfully";
        } else {
            throw new DuplicateKeyException("Item with ID " + item.getItemId() + " already exists");
        }
    }

    // Get all items by name and status
    @Override
    public List<ItemSaveRequestDTO> getItemByNameAndStatus(String itemName) {
        boolean activeState = true;
        List<Item> items = itemRepo.findAllByItemNameAndActiveState(itemName, activeState);
        if (items.isEmpty()) {
            throw new IllegalArgumentException("No item found with the name: " + itemName);
        }
        return modelMapper.map(items, new TypeToken<List<ItemSaveRequestDTO>>() {}.getType());
    }

    // Get all items by measure type
    @Override
    public List<ItemSaveRequestDTO> getItemsByMeasureType(MeasuringUnitType measureType) {
        List<Item> items = itemRepo.findAllByMeasuringUnitType(measureType);
        if (items.isEmpty()) {
            throw new IllegalArgumentException("No items found for measuring unit type: " + measureType);
        }
        return modelMapper.map(items, new TypeToken<List<ItemSaveRequestDTO>>() {}.getType());
    }


    // Get all items by active status with pagination
    @Override
    public PaginatedResponseItemDTO getAllItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {
        Page<Item> itemsPage = itemRepo.findAllByActiveState(activeStatus, PageRequest.of(page, size));
        if (itemsPage.isEmpty()) {
            throw new IllegalArgumentException("No items found for active status: " + activeStatus);
        }
        List<ItemSaveRequestDTO> itemDTOs = itemsPage.getContent().stream()
                .map(item -> modelMapper.map(item, ItemSaveRequestDTO.class))
                .collect(Collectors.toList());
        return new PaginatedResponseItemDTO(itemDTOs, itemsPage.getTotalElements());
    }


}
