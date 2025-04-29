/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class FnB implements Viewable {
    private static int fnbCount = 1;
    private String fnbId;
    private String name;
    private long price;
    private int Stock;
    public static List<FnB> fnbList = new ArrayList<>();

    
    public FnB(String name,  long price, int stock) {
        setFnbId  ("F"+getFnbCount());
        setName  (name);
        setPrice  (price);
        setStock  (stock);
        fnbCount++;
        fnbList.add(this);
    }

    public static int getFnbCount() {
        return fnbCount;
    }

    public static void setFnbCount(int fnbCount) {
        FnB.fnbCount = fnbCount;
    }

    public String getFnbId() {
        return fnbId;
    }

    public void setFnbId(String fnbId) {
        this.fnbId = fnbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }
    
    public String getPriceString() {
        return "IDR " + getPrice();
    }
    
    public void setPrice(long price) {
        this.price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public static List<FnB> getFnbList() {
        return fnbList;
    }

    public static void setFnbList(List<FnB> fnbList) {
        FnB.fnbList = fnbList;
    }

    
    //public void showSchedule() {
    //    System.out.println("Schedule for " + title + ": " + schedule.toString());
    //}
    
    @Override
    public void viewDetails(){
        System.out.println("FnB ID: \t"+getFnbId());
        System.out.println("Name:\t"+getName());
        System.out.println("Price:\t"+getPriceString());
        System.out.println("Stock:\t"+getStock());
    }
    
    //@Override
    public static void viewList(){
        System.out.println("| "+String.format("%-20s", "         Food") + " | " + String.format("%-15s", "     Price")+" |");
        for (FnB f : fnbList) {
            System.out.println("| " + String.format("%-20s", f.getName().length() > 20 ? f.getName().substring(0, 20) : f.getName()) 
                             + " | " + String.format("%15s", f.getPriceString().length() > 15 ? f.getPriceString().substring(0, 15) : f.getPriceString()) 
                             + " |");
        }
    }
}
