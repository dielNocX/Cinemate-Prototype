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
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

public class Order implements Viewable {
    private static int ticketCount = 0;
    private String ticketId;
    private List<String> seatNumber;
    private long fnbCost;
    private long cost;
    private Movie movie;
    private LocalDateTime time;
    private Payment payment;
    private HashMap<FnB, Integer> fnb = new HashMap<>();

    public Order(List<String> seatNumber, long cost, long fnbCost, Movie movie, LocalDateTime time) {
        setTicketId("T" + ++ticketCount);
        setSeatNumber(seatNumber);
        setCost(cost);
        setFnbCost(fnbCost);
        setMovie(movie);
        setTime(time);
    }

    @Override
    public void viewDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        System.out.println("Ticket ID:\t" + getTicketId());
        System.out.println("Seats:\t" + String.join(", ", getSeatNumber()));
        System.out.println("Cost:\tRp" + getCost());
        System.out.println("Movie:\t" + (getMovie() != null ? getMovie().getTitle() : "-"));
        System.out.println("Time:\t" + (getTime() != null ? getTime().format(formatter) : "-"));
    }

    public void orderTicket() {
        selectTime();
        orderSeat();
        orderFnb();
        calculateCost();
        orderSummary();
        payment = Payment.payOrder(this);
    }

    public void selectTime() {
        movie.showScheduleGroupedByDate();
        Scanner sc = new Scanner(System.in);

        int D, M, Y, h, m;
        
        System.out.println("Day:");
        D = sc.nextInt();
        System.out.println("Month:");
        M = sc.nextInt();
        System.out.println("Year:");
        Y = sc.nextInt();
        System.out.println("Hour:");
        h = sc.nextInt();
        System.out.println("Minute:");
        m = sc.nextInt();
        setTime(LocalDateTime.of(Y, M, D, h, m));
    }

    public void orderSeat() {
        showSeat();
        selectSeat();
    }

    public void selectSeat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input seat number: ");
        String input = sc.nextLine();
        while (!input.isEmpty()) {
            seatNumber.add(input);
            input = sc.nextLine();
            movie.getSeatMap().get(time).remove(input);
        }
    }

    public void showSeat() {
        int row = 0;
        int seatPerRow = 20;
        List<String> availableSeats = movie.getSeatMap().get(time);

        for (int seatNum = 1; seatNum <= 200; seatNum++) {
            String seat = String.valueOf(seatNum);

            if (availableSeats.contains(seat)) {
                System.out.print(seat + " ");
            } else {
                System.out.print("--- ");
            }

            if (++row >= seatPerRow) {
                row = 0;
                System.out.println();
            }
        }
    }


    public void orderFnb() {
        
        Scanner sc = new Scanner(System.in);
        FnB.viewList();
        int idx = FnB.selectFnb();
        
        while(idx >=0){
//            if (!sc.nextLine().isBlank() && !sc.nextLine().isEmpty()) break;
            int quantity;
            
            FnB selectedFnb = FnB.getFnbList().get(idx);
            if (fnb.containsKey(selectedFnb)) {
                System.out.println("Current quantity: " + fnb.get(selectedFnb));
                System.out.println("Update quantity:");
                quantity = sc.nextInt();
                fnb.put(selectedFnb, Integer.valueOf(quantity));
            } else {
                System.out.println("Quantity:");
                quantity = sc.nextInt();
                fnb.put(selectedFnb, Integer.valueOf(quantity));
            }
            FnB.viewList();
            idx = FnB.selectFnb();
            
        }
        
    }

    public void calculateCost() {
        long seatCost = (time.getDayOfWeek() == DayOfWeek.SATURDAY || time.getDayOfWeek() == DayOfWeek.SUNDAY) ? 50000 : 35000;
        cost = seatCost * seatNumber.size();
        fnbCost = 0;

        for (Map.Entry<FnB, Integer> entry : fnb.entrySet()) {
            FnB fnbItem = entry.getKey();
            Integer quantity = entry.getValue();
            fnbCost += fnbItem.getPrice() * quantity;
        }
    }

    public void orderSummary() {
        System.out.println("MOVIE");
        System.out.println("Title\t\t: " + movie.getTitle());
        System.out.println("Movie ID\t: " + movie.getMovieId());
        System.out.println("Genre\t\t: " + movie.getGenresString());
        System.out.println("Description\t: " + movie.getDescription());
        System.out.println("Schedule\t: " + time);
        System.out.println("Seat:\t");
        for (int i = 0; i < seatNumber.size(); i++) {
            System.out.print(seatNumber.get(i));
            if (i < seatNumber.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
        System.out.println("Movie cost: " + cost);

        System.out.println("FOOD & BEVERAGE");
        for (Map.Entry<FnB, Integer> item : fnb.entrySet()) {
            FnB key = item.getKey();
            Integer value = item.getValue();
            System.out.println(key.getName() + ": " + value + "\t\t " + key.getPrice());
        }
        System.out.println("Food & Beverage cost: " + fnbCost);
        System.out.println("\nTOTAL: " + (fnbCost + cost));
    }

    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public List<String> getSeatNumber() { return seatNumber; }
    public void setSeatNumber(List<String> seatNumber) { this.seatNumber = seatNumber; }
    public long getCost() { return cost; }
    public void setCost(long cost) { this.cost = cost; }
    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }
    public long getFnbCost() { return fnbCost; }
    public void setFnbCost(long fnbCost) { this.fnbCost = fnbCost; }
    public HashMap<FnB, Integer> getFnb() { return fnb; }
    public void setFnb(HashMap<FnB, Integer> fnb) { this.fnb = fnb; }
    public Payment getPayment() {return payment;}
    public void setPayment(Payment payment) {this.payment = payment;}

}

