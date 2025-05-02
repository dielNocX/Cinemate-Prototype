/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;
//import static com.pbo.cinemate.prototype.User.findUserByUsername;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Asus
 */
public abstract class Account {
    String username;
    String password;
    private String name;
    String role;
    String id;

    public static List<Account> accountList = new ArrayList<>();

    public Account(String usn,String psw,String name, String role,String id){
        setPassword(psw);
        setUsername(usn);
        setId(id);
        setName(name);
        setRole(role);
    }
    
    public String getRole() {
        return role;
    }

    public String getId() {
        return id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public static List<Account> getAccountList() {
        return accountList;
    }
    
        
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public abstract void showProfile();
        
    public static Account login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String inputUsername = sc.nextLine();
        System.out.print("Password: ");
        String inputPassword = sc.nextLine();

        Account acc = Account.findAccountByUsername(inputUsername);

        if (acc != null && acc.getPassword().equals(inputPassword)) {
            System.out.println("User " + acc.getUsername() + " logged in successfully.");
            return acc;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
        
    }
    
    public static Account findAccountByUsername(String username) {
        for (Account acc : accountList) {
            if (acc.getUsername().equals(username)) {
                return acc;
            }
        }
        return null;
    }

    
        
    
    
}
