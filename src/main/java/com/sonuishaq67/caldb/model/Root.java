package com.sonuishaq67.caldb.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

class Date{
 public String name;
 public String numeric;
}

class Observed{
 public String name;
 public String numeric;
}

class Requests{
 public int used;
 public int available;
 public String resets;
}

public class Root{
 public int status;
 public String warning;
 public Requests requests;
 public ArrayList<Holiday> holidays;
}

class Weekday{
 public Root date;
 public Observed observed;
}

