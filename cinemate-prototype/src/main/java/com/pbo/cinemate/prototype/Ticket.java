/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime ;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Asus
 */
public class Ticket implements Viewable {
    private static int ticketCount =0;
    private String ticketId;
    private List<String> seatNumber;
    private long cost;
    private Movie movie;
    private LocalDateTime time;
    
    public Ticket(List<String> seatNumber, long cost, Movie movie, LocalDateTime time){
        setTicketId("T" + ++ticketCount); 
        setSeatNumber(seatNumber);
        setCost(cost);
        setMovie(movie);
        setTime(time);
        
    }
    
    
    
    @Override
    public void viewDetails(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        System.out.println("Ticket ID:\t" + getTicketId());
        System.out.println("Seats:\t" +  String.join(", ", getSeatNumber()));
        System.out.println("Cost:\tRp" + getCost());
        System.out.println("Movie:\t" + (getMovie() != null ? getMovie().getTitle() : "-"));
        System.out.println("Time:\t" + (getTime() != null ? getTime().format(formatter) : "-"));
    }

    public int getTicketCount() {
        return ticketCount;
    }

    
    
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public List<String> getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(List<String> seatNumber) {
        this.seatNumber = seatNumber;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    
    
    
    
}
