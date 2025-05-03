/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders;  
    private LocalDateTime orderDate;  

    // Constructor
    public OrderHistory() {
        this.orders = new ArrayList<>();
        this.orderDate = LocalDateTime.now();  
    }


    public void addOrder(Order order) {
        orders.add(order);
    }

    public void showOrderHistory() {
        System.out.println("Order Date: " + orderDate);
        System.out.println("Orders: ");
        for (Order order : orders) {
            order.viewDetails(); 
        }
    }


    public List<Order> getTickets() {
        return orders;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}

