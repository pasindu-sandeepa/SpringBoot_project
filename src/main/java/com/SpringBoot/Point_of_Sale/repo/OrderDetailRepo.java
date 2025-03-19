package com.SpringBoot.Point_of_Sale.repo;

import com.SpringBoot.Point_of_Sale.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderDetailRepo extends JpaRepository<OrderDetails, Integer> {
}