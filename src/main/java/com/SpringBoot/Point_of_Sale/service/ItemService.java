package com.SpringBoot.Point_of_Sale.service;

import com.SpringBoot.Point_of_Sale.dto.paginated.PaginatedResponseItemDTO;
import com.SpringBoot.Point_of_Sale.dto.request.ItemSaveRequestDTO;
import com.SpringBoot.Point_of_Sale.entity.enums.MeasuringUnitType;

import java.util.List;

public interface ItemService {


    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemSaveRequestDTO> getItemByNameAndStatus(String itemName);

    List<ItemSaveRequestDTO> getItemsByMeasureType(MeasuringUnitType measureType);

    PaginatedResponseItemDTO getAllItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size);
}
