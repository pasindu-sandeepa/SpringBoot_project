package com.SpringBoot.Point_of_Sale.repo;

import com.SpringBoot.Point_of_Sale.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
    List<Item> findAllByItemNameAndActiveState(String itemName, boolean activeState);


}

