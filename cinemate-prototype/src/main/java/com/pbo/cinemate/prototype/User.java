package com.pbo.cinemate.prototype;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;  

public class User extends Account {

    private static int userCount = 0;
    private String noTelp;
    private OrderHistory orderHistory;  // One-to-one composition relationship with OrderHistory

    // Constructor
    public User(String name, String username, String password) {
        super(username, password, name, "User", "U" + ++userCount); // Call to the constructor of Account class
        accountList.add(this);
        this.orderHistory = new OrderHistory();  // Initialize the OrderHistory
    }

    // Getter and Setter methods
    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    // Show user profile
    @Override
    public void showProfile() {
        System.out.println("ID:\t" + getId());
        System.out.println("Nama:\t" + getName());
        System.out.println("Username:\t" + getUsername());
        System.out.println("No. Telepon:\t" + ((getNoTelp() != null) ? getNoTelp() : "-"));
    }

    // User register method
    public static void register() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            System.out.print("Enter name: ");
            String nama = sc.nextLine();

            if (Account.findAccountByUsername(username) == null) {
                new User(nama, username, password);
                System.out.println("User " + nama + " registered successfully.");
                break;
            } else {
                System.out.println("Username already exist.");
            }
        }
    }

    // User makes an order
    public void orderMovie() {
        Movie selectedMovie =  selectMovie(); // For now, select the first movie
        Order order = new Order(new ArrayList<>(), 0, 0, selectedMovie, null);
        order.orderTicket();  

        orderHistory.addOrder(order);  
    }
    
    public Movie selectMovie(){
        Scanner sc = new Scanner(System.in);
        Movie.viewList();
        System.out.println("Pilih film: ");
        int input = sc.nextInt()-1;
        return Movie.getMovieList().get(input);
    }


    public void showOrderHistory() {
        orderHistory.showOrderHistory();  
    }
}
