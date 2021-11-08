package com.example.ordertaskteamvoy_hrymovskyi.rest;

import com.example.ordertaskteamvoy_hrymovskyi.Model.Order;
import com.example.ordertaskteamvoy_hrymovskyi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders/")
public class OrderRestControllerV1 {

    @Autowired
    private OrderService orderService;


    //method GetOrderById
    @RequestMapping(value = "{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long orderId){
        if(orderId==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Order> order = this.orderService.getById(orderId);

        if(order==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //method SaveOrder
    @RequestMapping(value = "", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> saveOrders(@RequestBody Order order){
        HttpHeaders headers = new HttpHeaders();

        if(order==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.orderService.save(order);
        return new ResponseEntity<>(order,headers, HttpStatus.CREATED);
    }

    //method DeleteOrder
    @RequestMapping(value = "", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Order> deleteOrders(){
        var dateNow = new Date();
        var date_10Min = new Date(dateNow.getTime() - 600000); //time of 10 minutes ago
        orderService.deleteAllByCreatedAtBefore(date_10Min);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //method GetAllOrders
    @RequestMapping(value = "",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = this.orderService.getAll();
        if(orders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

