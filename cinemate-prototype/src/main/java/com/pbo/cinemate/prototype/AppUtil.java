/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.cinemate.prototype;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Asus
 */
public class AppUtil {
    
    private static final DateTimeFormatter  formatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    
    @SafeVarargs
    public static <T> ArrayList<T> arrayListOf(T... elements) {
        return new ArrayList<>(List.of(elements));
    }
    
    public static ArrayList<LocalDateTime> createScheduleList(List<LocalDateTime> dateTimes) {
    // Example: Sorting the list before returning
    dateTimes.sort((d1, d2) -> d1.compareTo(d2));
    return new ArrayList<>(dateTimes);
}
    

}
