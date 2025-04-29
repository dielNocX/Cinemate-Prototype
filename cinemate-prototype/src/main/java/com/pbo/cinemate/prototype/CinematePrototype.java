/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pbo.cinemate.prototype;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Asus
 */
public class CinematePrototype {

    public static void main(String[] args) {        
        normalFlowRegister();
        fillMovie();
        Movie.viewList();
        fillFnb();
        FnB.viewList();
    }
    
    public static User normalFlowRegister(){
        User.register();
        User user = null;
        while (user == null) {
            user = User.login();
        }
        if (user != null) {
            user.showProfile(); 
        }
        return user;
    }
    
    public static void fillMovie(){
        Movie M[] = {
            new Movie("Jumbo", new ArrayList<>(List.of("Horror")), LocalDate.of(2025, 5, 1), "Film jumbo"),
            new Movie("Cepat & Marah", new ArrayList<>(List.of("Action")), LocalDate.of(2025, 6, 10), "Balapan jalanan penuh emosi"),
            new Movie("Manusia Laba-laba", new ArrayList<>(List.of("Action")), LocalDate.of(2025, 7, 3), "Pahlawan berkostum laba-laba"),
            new Movie("Pahlawan Perisai", new ArrayList<>(List.of("Action")), LocalDate.of(2025, 8, 21), "Prajurit super dengan perisai bintang"),
            new Movie("Serigala dari Sudirman", new ArrayList<>(List.of("Drama")), LocalDate.of(2025, 9, 15), "Kisah ambisi di dunia finansial Jakarta"),
            new Movie("Mainan Ceria", new ArrayList<>(List.of("Animation")), LocalDate.of(2025, 10, 5), "Mainan yang hidup saat manusia tak melihat"),
            new Movie("Dokter Aneh", new ArrayList<>(List.of("Fantasy")), LocalDate.of(2025, 11, 11), "Penyihir ahli waktu dan dunia paralel"),
            new Movie("Si Cepat", new ArrayList<>(List.of("Animation")), LocalDate.of(2025, 12, 1), "Landak biru berlari menyelamatkan dunia"),
            new Movie("Dewi Es", new ArrayList<>(List.of("Animation")), LocalDate.of(2026, 1, 2), "Putri dengan kekuatan salju dan lagu yang meledak"),
            new Movie("Petualangan di Rawa", new ArrayList<>(List.of("Fantasy")), LocalDate.of(2026, 2, 14), "Ogre hijau dan keledai cerewet")
        };
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
