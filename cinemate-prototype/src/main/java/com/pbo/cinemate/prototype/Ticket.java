/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;

/*import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDateTime ;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;*/
/**
 *
 * @author Asus
 */
public class Ticket /*implements Viewable*/ { //UNUSED CLASS
    /*private static int ticketCount =0;
    private String ticketId;
    private List<String> seatNumber ;
    private long fnbCost;
    private long cost;
    private Movie movie;
    private LocalDateTime time;
    private HashMap<FnB, Integer> fnb = new HashMap<>();
    
    public Ticket(List<String> seatNumber, long cost, long fnbCost, Movie movie, LocalDateTime time){
        setTicketId("T" + ++ticketCount); 
        setSeatNumber(seatNumber);
        setCost(cost);
        setFnbCost(fnbCost);
        setMovie(movie);
        setTime(time);
        
    }

    public long getFnbCost() {
        return fnbCost;
    }

    public void setFnbCost(long fnbCost) {
        this.fnbCost = fnbCost;
    }

    public HashMap<FnB, Integer> getFnb() {
        return fnb;
    }

    public void setFnb(HashMap<FnB, Integer> fnb) {
        this.fnb = fnb;
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
    
//    public void order(){{
     //   
//    }
    
    
    
    public void selectSeat() {
        
        Scanner sc = new Scanner (System.in);
        
//        List<String> ticketSeatNumber = new ArrayList<>();
        
        String input = sc.nextLine();
        while (input != ""){
            seatNumber.add(input);
            input = sc.nextLine();
        }
//        return ticketSeatNumber;
    } 
    
    public void showSeat(){
        int row = 0;
        for (String s : movie.getSeatMap().get(time)){
            if (row++ >=10){
                row =0;
                System.out.println("");
            } 
            System.out.print(s + " ");
        }
    }
    
    public void orderSeat(){
        showSeat();
        selectSeat();
    }
    
    public void selectTime(){
        movie.showScheduleGroupedByDate();
        Scanner sc = new Scanner (System.in);
        
        int D,M,Y,h,m;
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
        setTime(LocalDateTime.of(Y,M,D,h,m));
            
    }
    
    public void order(){
        
        movie.viewDetails();
        selectTime();
        orderSeat();
        orderFnb();
        Ticket newTicket = new Ticket(seatNumber, cost,fnbCost, movie, time);
        orderSummary();
    }
    
    public void orderSummary(){
        System.out.println("MOVIE");    
        System.out.println("Title\t\t: "+movie.getTitle());
        System.out.println("Movie ID\t\t: "+movie.getMovieId());
        System.out.println("Genre\t\t: "+movie.getGenresString());
        System.out.println("Description\t: "+movie.getDescription());
        System.out.println("Schedule\t\t: "+time);
        System.out.println("Seat:\t");
        
        for (int i = 0; i < seatNumber.size(); i++) {
            System.out.print(seatNumber.get(i));
            
            if (i < seatNumber.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
        
        System.out.println("Movie cost: "+cost);
        
        System.out.println("FOOD & BEVERAGE");
        for (Map.Entry<FnB, Integer> item : fnb.entrySet()) {
            FnB key = item.getKey();
            Integer value = item.getValue();
            System.out.println(key.getName() + ": " + value+ "\t\t " +key.getPrice());
        }
        
        System.out.println("Food & Beverage cost: "+fnbCost);
        
        System.out.println("\nTOTAL: "+(fnbCost+cost));
        
    }
    
    
    public void orderFnb(){
        FnB.viewList();
        int idx = FnB.selectFnb();
        Scanner sc = new Scanner (System.in);
        
        int quantity;
        FnB selectedFnb = FnB.getFnbList().get(idx);
        if (fnb.containsKey(selectedFnb)){
            System.out.println("Current quantity: "+fnb.get(selectedFnb));
            System.out.println("Update quantity:");
            quantity = sc.nextInt();
            fnb.put(selectedFnb, Integer.valueOf(quantity));
            

        }else {
            System.out.println("Quantity:");
            quantity = sc.nextInt();
            fnb.put(selectedFnb,Integer.valueOf(quantity));
        }
    }
    
    
    public void calculateCost() {
        long seatCost;
        
        if (time.getDayOfWeek() == DayOfWeek.SATURDAY || time.getDayOfWeek()  == DayOfWeek.SUNDAY) {
            seatCost = 50000;
        } else {
            seatCost = 50000;
        }
        cost = seatCost * seatNumber.size();
        fnbCost = 0;

        // Calculate FnB cost
        for (Map.Entry<FnB, Integer> entry : fnb.entrySet()) {
            FnB fnbItem = entry.getKey();
            Integer quantity = entry.getValue();
            fnbCost += fnbItem.getPrice() * quantity; 
        }


        //return cost + fnbCost;
    }
    */
    
    
    
    
}
