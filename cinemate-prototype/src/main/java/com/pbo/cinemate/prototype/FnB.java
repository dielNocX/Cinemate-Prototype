/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    
    public static void showFnb(int idx){
        getFnbList().get(--idx).viewDetails();
    }
    
    public static void selectFnb(){
        System.out.print("Pilih nomor menu: ");
        Scanner sc = new Scanner(System.in);
        showFnb(sc.nextInt());
    }
    
    @Override
    public void viewDetails(){
        System.out.println("Menu item\t: "+getName());
        System.out.println("Menu ID\t\t: "+getFnbId());
        System.out.println("Price\t\t: "+getPriceString());
        System.out.println("Stock\t\t: "+getStock());
    }
    
    //@Override
    public static void viewList(){
        System.out.println("|  No "+"| "+String.format("%-20s", "         MENU") + " | " + String.format("%-20s", "      PRICE")+" |");
        int i=0;
        for (FnB f : fnbList) {
            System.out.println("| " +String.format("%3s", String.valueOf(++i)  )+ " | "+ String.format("%-20s", f.getName().length() > 20 ? f.getName().substring(0, 20) : f.getName()) 
                             + " | " + String.format("%20s", f.getPriceString().length() > 20 ? f.getPriceString().substring(0, 20) : f.getPriceString()) 
                             + " |");
        }
        System.out.println("");
    }
    
    public static void fillFnb() {
        FnB[] fnbItems = {
            new FnB("Popcorn Caramel", 25000, 50),
            new FnB("Popcorn Butter", 22000, 40),
            new FnB("Cola Regular", 15000, 60),
            new FnB("Cola Large", 20000, 40),
            new FnB("Teh Manis", 12000, 50),
            new FnB("Air Mineral", 10000, 70),
            new FnB("Burger Mini", 30000, 20),
            new FnB("Sosis Bakar", 18000, 25),
            new FnB("French Fries Regular", 20000, 35),
            new FnB("French Fries Large", 24000, 35)
        };
    }
}
