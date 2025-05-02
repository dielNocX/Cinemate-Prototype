/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;

/**
 *
 * @author Asus
 */
import java.time.LocalDateTime ;
import java.util.ArrayList;
import java.util.List;  
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;  
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

public class Movie implements Viewable {
    private static int movieCount = 1;
    private String movieId;
    private String title;
    private String description;
    private List<String> genres;
    private List<LocalDateTime>  schedule;
    private static List<Movie> movieList = new ArrayList<>();
    private Map<LocalDateTime, List<String>> seatMap = new HashMap<>(); // can be 
    
    public Movie(String title,  List<String> genres, List<LocalDateTime> schedule,String description) {
        setMovieId  ("M"+getMovieCount());
        setTitle  (title);
        setDescription  (description);
        setGenre  (genres);
        setSchedule(schedule);
        movieCount++;
        movieList.add(this);
    }

    public static List<Movie> getMovieList() {
        return movieList;
    }

    public static void setMovieList(List<Movie> movieList) {
        Movie.movieList = movieList;
    }

    public static int getMovieCount() {
        return movieCount;
    }

    public static void setMovieCount(int movieCount) {
        Movie.movieCount = movieCount;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenres() {
        return genres;
    }
    
    public String getGenresString() {
        String str = "";
        for (String genre : genres){
           str += genre + ", "; 
        }
        if (genres.size()>0){
            str = str.substring(0, str.length()-2);
        } else str = "-";
        return str;
        
 
    }
    
    public void setGenre(List<String> genres) {
        this.genres = genres;
    }

    public List<LocalDateTime> getSchedule() {
        return schedule;
    }
    
    public String getScheduleString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm   dd-MM-yyyy ");
        return schedule.stream()
                       .map(dateTime -> dateTime.format(formatter))
                       .collect(Collectors.joining("\n\t\t  "));
    }

    public void setSchedule(List<LocalDateTime> schedule) {
        this.schedule = schedule;

        // seats for each schedule
        for (LocalDateTime time : schedule) {
            List<String> seats = new ArrayList<>();
            for (int i = 1; i <= 200; i++) {
                seats.add(String.valueOf(i));
            }
            seatMap.put(time, seats);
        }
    }   
    
    public java.util.Map<LocalDateTime, List<String>> getSeatMap() {
        return seatMap;
    }
    
    public void showSchedule() {
        System.out.println("Schedule for " + title + ": " + schedule.toString());
    }
    
    @Override
    public void viewDetails(){
        System.out.println("Title\t\t: "+getTitle());
        System.out.println("Movie ID\t\t: "+getMovieId());
        System.out.println("Genre\t\t: "+getGenresString());
        System.out.println("Description\t: "+getDescription());
        System.out.println("Schedule\t\t: "+getScheduleString());
    }
    
    public static void showMovie(int idx){
        getMovieList().get(--idx).viewDetails();
    }
    
    public static void selectMovie(){
        System.out.print("Pilih nomor film: ");
        Scanner sc = new Scanner(System.in);
        showMovie(sc.nextInt());
    }
    
    //@Override
    public static void viewList(){
        System.out.println("|  No "+"| "+String.format("%-20s", "       TITLE") + " | " + String.format("%-20s", "       GENRE")+" |");
        int i=0;
        for (Movie m : movieList) {
            System.out.println("| " + String.format("%3s", String.valueOf(++i)  )
                             + " | " + String.format("%-20s", m.getTitle().length() > 20 ? m.getTitle().substring(0, 20) : m.getTitle()) 
                             + " | " + String.format("%20s", m.getGenresString().length() > 20 ? m.getGenresString().substring(0, 20) : m.getGenresString()) 
                             + " |");
        }
        System.out.println("");
    }
    
    public static void fillMovie(){
        List<Movie> movies = List.of(
            new Movie("Jumbo", AppUtil.arrayListOf("Horror"), AppUtil.arrayListOf(LocalDateTime.of(2025, 5, 1, 0, 0)), "Film jumbo"),
            new Movie("Cepat & Marah", AppUtil.arrayListOf("Action"), AppUtil.arrayListOf(LocalDateTime.of(2025, 6, 10, 0, 0)), "Balapan jalanan penuh emosi"),
            new Movie("Manusia Laba-laba", AppUtil.arrayListOf("Action"), AppUtil.arrayListOf(LocalDateTime.of(2025, 7, 3, 0, 0)), "Pahlawan berkostum laba-laba"),
            new Movie("Pahlawan Perisai", AppUtil.arrayListOf("Action"), AppUtil.arrayListOf(LocalDateTime.of(2025, 8, 21, 0, 0), LocalDateTime.of(2025, 8, 21, 9, 0)), "Prajurit super dengan perisai bintang"),
            new Movie("Serigala dari Sudirman", AppUtil.arrayListOf("Drama"), AppUtil.arrayListOf(LocalDateTime.of(2025, 9, 15, 0, 0)), "Kisah ambisi di dunia finansial Jakarta"),
            new Movie("Mainan Ceria", AppUtil.arrayListOf("Animation"), AppUtil.arrayListOf(LocalDateTime.of(2025, 10, 5, 10, 30)), "Mainan yang hidup saat manusia tak melihat"),
            new Movie("Dokter Aneh", AppUtil.arrayListOf("Fantasy","Horror"), AppUtil.arrayListOf(LocalDateTime.of(2025, 11, 11, 0, 0)), "Penyihir ahli waktu dan dunia paralel"),
            new Movie("Si Cepat", AppUtil.arrayListOf("Animation"), AppUtil.arrayListOf(LocalDateTime.of(2025, 12, 1, 0, 0)), "Landak biru berlari menyelamatkan dunia"),
            new Movie("Dewi Es", AppUtil.arrayListOf("Animation"), AppUtil.arrayListOf(LocalDateTime.of(2026, 1, 2, 0, 0)), "Putri dengan kekuatan salju dan lagu yang meledak"),
            new Movie("Petualangan di Rawa", AppUtil.arrayListOf("Fantasy"), AppUtil.arrayListOf(LocalDateTime.of(2026, 2, 14, 0, 0)), "Ogre hijau dan keledai cerewet")
        );
    }
    
}

