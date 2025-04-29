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
}
