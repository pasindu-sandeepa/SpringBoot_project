package com.SpringBoot.Point_of_Sale.dto.paginated;

import com.SpringBoot.Point_of_Sale.dto.request.ItemSaveRequestDTO;

import java.util.List;

public class PaginatedResponseItemDTO {
    private List<ItemSaveRequestDTO> list;
    private long dataCount;

    public PaginatedResponseItemDTO() {
    }

    public PaginatedResponseItemDTO(List<ItemSaveRequestDTO> list, long dataCount) {
        this.list = list;
        this.dataCount = dataCount;
    }

    public List<ItemSaveRequestDTO> getList() {
        return list;
    }

    public void setList(List<ItemSaveRequestDTO> list) {
        this.list = list;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    @Override
    public String toString() {
        return "PaginatedResponseItemDTO{" +
                "list=" + list +
                ", dataCount=" + dataCount +
                '}';
    }
}