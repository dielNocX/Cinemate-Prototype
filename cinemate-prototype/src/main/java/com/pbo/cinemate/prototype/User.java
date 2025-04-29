package com.pbo.cinemate.prototype;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class User extends Account {

    private static int userCount = 1;
    private String nama;
    private String noTelp;
    
    public static List<User> userList = new ArrayList<>();

    // Constructor
    public User(String nama, String username, String password, String noTelp) {
        super(username, password,"User","U" + userCount ); // Call to the constructor of Account class
        this.setNama(nama);
        this.setNoTelp(noTelp);
        userCount++;
        userList.add(this);
    }

    // Getter and Setter methods

    public String getNama() {
        return nama;
    }
    
    public String getNoTelp() {
        return noTelp;
    }
    
    public void setNama(String nama) {
        this.nama=nama;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp=noTelp;
    }

    public static User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;  // Return null if no user found
    }

    public static User login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String inputUsername = sc.nextLine();
        System.out.print("Password: ");
        String inputPassword = sc.nextLine();

        User user = findUserByUsername(inputUsername);
        if (user != null && user.getPassword().equals(inputPassword)) {
            System.out.println("User " + user.getUsername() + " logged in successfully.");
            return user;
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
        System.out.print("Enter phone number: ");
        String noTelp = sc.nextLine();

        new User(nama, username, password, noTelp);
        System.out.println("User " + nama + " registered successfully.");
    }
    
    @Override
    public void showProfile(){
        System.out.println("ID:\t"+getId());
        System.out.println("Nama:\t"+getNama());
        System.out.println("Username:\t"+getUsername());
        System.out.println("No. Telepon:\t"+getNoTelp());
        //System.out.println(""+get);
    }
}
