package com.example.ordertaskteamvoy_hrymovskyi.service;

import com.example.ordertaskteamvoy_hrymovskyi.Model.Order;
import com.example.ordertaskteamvoy_hrymovskyi.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderImplementation implements OrderService{

    @Autowired
    OrderRepo orderRepo;

    @Override
    public void save(Order order) {
        orderRepo.save(order);
    }

    @Override
    public void delete(Order order) {
        orderRepo.delete(order);
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepo.findById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    @Override
    public void deleteAllByCreatedAtBefore(Date date) {

    }
}
