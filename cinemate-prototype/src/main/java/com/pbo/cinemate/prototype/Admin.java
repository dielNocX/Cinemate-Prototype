/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Admin extends Account{
    private static int adminCount = 0;

    private static List<Admin> adminList = new ArrayList<>();

    // Constructor
    public Admin(String username, String password,String name) {
        super(username, password, name,"ADMIN","A" + ++adminCount ); // Call to the constructor of Account class
        adminList.add(this);
    }



    /*public static Admin findAdminByUsername(String username) {
        for (Admin admin : adminList) {
            if (admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;  
    }

    public static Admin login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String inputUsername = sc.nextLine();
        System.out.print("Password: ");
        String inputPassword = sc.nextLine();

        Admin admin = findAdminByUsername(inputUsername);
        if (admin != null && admin.getPassword().equals(inputPassword)) {
            System.out.println("Admin " + admin.getUsername() + " logged in successfully.");
            return admin;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

    
    public static void register(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter name: ");
        String nama = sc.nextLine();

        new Admin(nama, username, password);
        System.out.println("User " + nama + " registered successfully.");
    }*/ 
    public void createAdmin(){
        
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            System.out.print("Enter name: ");
            String nama = sc.nextLine();

            
            if (Account.findAccountByUsername(username) != null) {
                new Admin(nama, username, password);
                System.out.println("Admin " + nama + " created successfully.");
                break;
            }
        }
        
        
 
        
    }
    
    
    
    

    
    @Override
    public void showProfile(){
        System.out.println("ID\t\t: "+getId());
        System.out.println("Nama\t: "+getName());
        System.out.println("Username\t: "+getUsername());
        System.out.println("Role\t: "+ getRole());
        //System.out.println(""+get);
    }
    
    public void menuMovie(){
        System.out.println("Type :\n1 - Create\n2 - Update\n3 - Delete\n");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            case 1:
                createMovie();
                break;
            
            case 2:
                updateMovie();
                break;
            
            case 3:
                deleteMovie();
                break;
            
                        
        }
    }
    
    public void createMovie() {
        //implementation
//        Movie movie = new Movie(title, duration, price);
//        movieList.add(movie);
//        System.out.println("Movie added: " + title);
    }

    public void updateMovie() {
//        if (index >= 0 && index < movieList.size()) {
//            Movie movie = movieList.get(index);
//            movie.setTitle(newTitle);
//            movie.setDuration(newDuration);
//            movie.setPrice(newPrice);
//            System.out.println("Movie updated: " + newTitle);
//        } else {
//            System.out.println("Invalid movie index.");
//        }
    }

    public void deleteMovie() {
//        if (index >= 0 && index < movieList.size()) {
//            Movie removed = movieList.remove(index);
//            System.out.println("Movie deleted: " + removed.getTitle());
//        } else {
//            System.out.println("Invalid movie index.");
//        }
    }


}
