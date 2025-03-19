package com.SpringBoot.Point_of_Sale.repo;

import com.SpringBoot.Point_of_Sale.entity.Item;
import com.SpringBoot.Point_of_Sale.entity.enums.MeasuringUnitType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer> {
    List<Item> findAllByItemNameAndActiveState(String itemName, boolean activeState);
    List<Item> findAllByMeasuringUnitType(MeasuringUnitType measuringUnitType);
    Page<Item> findAllByActiveState(boolean activeState, Pageable pageable);
}

