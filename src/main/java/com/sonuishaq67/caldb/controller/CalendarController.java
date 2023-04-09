package com.sonuishaq67.caldb.controller;

import java.util.ArrayList;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonuishaq67.caldb.model.Day;
import com.sonuishaq67.caldb.model.Holiday;
import com.sonuishaq67.caldb.model.Root;
import com.sonuishaq67.caldb.service.CalendarService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private CalendarService calendarService = new CalendarService();

    @GetMapping("/current")
    public ArrayList<Day> getCurrentMonthCalendarAll() {
        String strx = java.time.LocalDate.now().toString();
        String[] arr = strx.split("-", 0);
        int month = Integer.valueOf(arr[1]);
        int year = Integer.valueOf(arr[0])-1;
        return calendarService.getMonthCalendarAll(month, year);
        
    }
    
    @GetMapping("/{country}/current")
    public ArrayList<Day> getCurrentMonthCalendar(@PathVariable String country) {
        String strx = java.time.LocalDate.now().toString();
        String[] arr = strx.split("-", 0);
        int month = Integer.valueOf(arr[1]);
        int year = Integer.valueOf(arr[0])-1;
        return calendarService.getMonthCalendar(country,month, year);
        
    }
    
    @GetMapping("/{country}/{month}/{year}")
    public ArrayList<Day> getMonthCalendar(@PathVariable String country,@PathVariable int month, @PathVariable int year) {
        ArrayList<Day> arr = calendarService.getMonthCalendar(country,month, year);
        return arr;
    }
    
    @GetMapping("/{month}/{year}")
    public ArrayList<Day> getMonthCalendarAll(@PathVariable int month, @PathVariable int year) {
        ArrayList<Day> arr = calendarService.getMonthCalendarAll(month, year);
        return arr;
    }
}