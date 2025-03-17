package com.SpringBoot.Point_of_Sale.controller;

import com.SpringBoot.Point_of_Sale.dto.paginated.PaginatedResponseItemDTO;
import com.SpringBoot.Point_of_Sale.dto.request.ItemSaveRequestDTO;
import com.SpringBoot.Point_of_Sale.entity.enums.MeasuringUnitType;
import com.SpringBoot.Point_of_Sale.service.ItemService;
import com.SpringBoot.Point_of_Sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Save Item
    @PostMapping(
            path = "/save"
    )
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message = itemService.saveItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",message),
                HttpStatus.CREATED
        );
   }

    // Get all items by name and status
    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemSaveRequestDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemSaveRequestDTO> itemDTO = itemService.getItemByNameAndStatus(itemName);
        return itemDTO;
    }

  // Get all items by measure type
    @GetMapping(
            path = "/get-by-measure-type",
            params = "measureType")
    public List<ItemSaveRequestDTO> getItemsByMeasureType(@RequestParam(value = "measureType") MeasuringUnitType measureType){
        return itemService.getItemsByMeasureType(measureType);
    }

    // Get all items by status
    @GetMapping(path = "/get-all-item-by-status", params = {"activeStatus", "page", "size"})
    public ResponseEntity<StandardResponse> getAllItemByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getAllItemByActiveStatusWithPaginated(activeStatus, page, size);
        return new ResponseEntity<>(
                new StandardResponse(200, "success", paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }
}



