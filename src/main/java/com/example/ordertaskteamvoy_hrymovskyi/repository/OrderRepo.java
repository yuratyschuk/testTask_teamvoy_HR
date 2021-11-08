package com.example.ordertaskteamvoy_hrymovskyi.repository;


import com.example.ordertaskteamvoy_hrymovskyi.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
