/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;

/**
 *
 * @author Asus
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Viewable {
    private static int movieCount = 1;
    private String movieId;
    private String title;
    private String description;
    private List<String> genres;
    private LocalDate schedule;
    public static List<Movie> movieList = new ArrayList<>();

    
    public Movie(String title,  List<String> genres, LocalDate schedule,String description) {
        setMovieId  ("M"+getMovieCount());
        setTitle  (title);
        setDescription  (description);
        setGenre  (genres);
        setSchedule(schedule);
        movieCount++;
        movieList.add(this);
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

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }
    
    public void showSchedule() {
        System.out.println("Schedule for " + title + ": " + schedule.toString());
    }
    
    @Override
    public void viewDetails(){
        System.out.println("Movie ID: \t"+getMovieId());
        System.out.println("Title:\t"+getTitle());
        System.out.println("Genre:\t"+getGenresString());
        System.out.println("Schedule:\t"+getSchedule());
        System.out.println("Description:\t"+getDescription());
    }
    
    //@Override
    public static void viewList(){
        System.out.println("| "+String.format("%-20s", "       Title") + " | " + String.format("%-12s", "  Genre")+" |");
        for (Movie m : movieList) {
            System.out.println("| " + String.format("%-20s", m.getTitle().length() > 20 ? m.getTitle().substring(0, 20) : m.getTitle()) 
                             + " | " + String.format("%12s", m.getGenresString().length() > 12 ? m.getGenresString().substring(0, 12) : m.getGenresString()) 
                             + " |");
        }
    }
}

