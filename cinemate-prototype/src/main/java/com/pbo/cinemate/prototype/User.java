package com.pbo.cinemate.prototype;

import java.util.Scanner;


public class User extends Account {

    private static int userCount = 0;
    
    private String noTelp;

    // Constructor
    public User(String name, String username, String password) {
        super(username, password,name,"User","U" + ++userCount ); // Call to the constructor of Account class
        accountList.add(this);
    }

    // Getter and Setter methods

    
    
    public String getNoTelp() {
        return noTelp;
    }
    

    public void setNoTelp(String noTelp) {
        this.noTelp=noTelp;
    }

    
    public void showProfile(){
        System.out.println("ID:\t"+getId());
        System.out.println("Nama:\t"+getName());
        System.out.println("Username:\t"+getUsername());
        System.out.println("No. Telepon:\t"+((getNoTelp()!=null)?getNoTelp() : "-"));
        //System.out.println(""+get);
    }
    
    public static void register(){
        
        while (true){
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
    
    
    
}
