/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;

/**
 *
 * @author Asus
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDateTime;

public class Payment {
    private static int paymentCount = 0;
    private static List<Payment> paymentList = new ArrayList<>();

    private String paymentId;
    private long totalCost;
    private LocalDateTime paymentTime;

    public Payment(long totalCost) {
        this.paymentId = "P" + ++paymentCount;
        this.totalCost = totalCost;
        this.paymentTime = LocalDateTime.now();
        paymentList.add(this);
    }

    public static List<Payment> getPaymentList() {
        return paymentList;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public static Payment payOrder(Order order) {
        long total = order.getCost() + order.getFnbCost();        
        Scanner sc = new Scanner(System.in);
        long input = -1;

        System.out.println("Total payment due: Rp" + total);
        while (input != total) {
            System.out.print("Enter payment amount: ");
            try {
                input = Long.parseLong(sc.nextLine());
                if (input != total) {
                    System.out.println("Payment failed! Wrong amount.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        Payment payment = new Payment(total);
        order.setPayment(payment);
        System.out.println("Payment successful! Payment ID: " + payment.getPaymentId() + ", Amount: Rp" + total);
        return payment;
    }


}
