package com.sonuishaq67.caldb.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.sonuishaq67.caldb.model.Day;
import com.sonuishaq67.caldb.model.Holiday;
import com.sonuishaq67.caldb.model.Root;

public class CalendarService {

    public ArrayList<Holiday> getMonthHolidays(String country,int month, int year) {        
    	try {
        URL url = new URL("https://holidayapi.com/v1/holidays?pretty&key=5a6b3669-a1ae-4e79-a48e-798c42307f3d&country="+country+"&year="+year+"&month="+month);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String jsonString = response.toString();
        System.out.println(jsonString);
        Gson gson = new Gson();   
        Root jsonObj = gson.fromJson(jsonString, Root.class);
        return jsonObj.holidays;	
    }
    	catch (Exception e){
    		System.out.println(e);
    	}
  	
    	return null;
    }

	public ArrayList<Day> getMonthCalendar(String country,int month, int year) {
		ArrayList<Day> ret=new ArrayList<Day>();
		// get number of days 
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int noOfDays=yearMonthObject.lengthOfMonth();
		Format f = new SimpleDateFormat("EEEE");
		ArrayList<Holiday> events=getMonthHolidays(country,month, year);
		
		for (int i=1;i<=noOfDays;i++)
		{
			Day xday=new Day();
			xday.setDate(i);
			String str = f.format(new Date(year-1900,month-1,i));
			xday.setDay(str);
			ret.add(xday);
		}
		
		
		if(events!=null)
		for (Holiday holi:events) {
			int ddate=Integer.valueOf(holi.date.split("-")[2]);
			Day currDay=ret.get(ddate-1);
			ArrayList<String> x = currDay.getEvents();
			x.add(holi.getName());
			currDay.setEvents(x);
			ret.set(ddate-1, currDay);
		}
		
		
		
		return ret;
	}

	public ArrayList<Day> getMonthCalendarAll(int month, int year) {
		ArrayList<Day> ret=new ArrayList<Day>();
		// get number of days 
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int noOfDays=yearMonthObject.lengthOfMonth();
		Format f = new SimpleDateFormat("EEEE");
		
		ArrayList<Holiday> events=getMonthHolidays("IN",month, year);
		ArrayList<Holiday> eventsUS=getMonthHolidays("US",month, year);
		
		for (int i=1;i<=noOfDays;i++)
		{
			Day xday=new Day();
			xday.setDate(i);
			String str = f.format(new Date(year-1900,month-1,i));
			xday.setDay(str);
			ret.add(xday);
		}
		
		
		if(events!=null)
		for (Holiday holi:events) {
			int ddate=Integer.valueOf(holi.date.split("-")[2]);
			Day currDay=ret.get(ddate-1);
			ArrayList<String> x = currDay.getEvents();
			x.add(holi.getName());
			currDay.setEvents(x);
			ret.set(ddate-1, currDay);
		}
		
		if(eventsUS!=null)
			for (Holiday holi:eventsUS) {
				int ddate=Integer.valueOf(holi.date.split("-")[2]);
				Day currDay=ret.get(ddate-1);
				ArrayList<String> x = currDay.getEvents();
				x.add(holi.getName());
				currDay.setEvents(x);
				ret.set(ddate-1, currDay);
			}
		
		
		
		return ret;
	}
    

}		
