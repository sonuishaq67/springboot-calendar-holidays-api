# springboot-calendar-holidays-api


Currently I have implemented 4 endpoints for the api


Following functionalities to be supported:
- [x] Show any selected month’s calendar
- [x] Show current month’s calendar
- [x] Show holidays for selected holiday types eg. Indian holidays, US holidays, Company holidays

Bonus (personal events):
- [] Support adding personal events to the calendar
- [] View these events on the calendar



1) GET /calendar/{month}/{year}

    Gets an array of days with events alongside from 2 countries US, IN 
    Example - http://localhost:8080/calendar/4/2022
    Response - [response](response/calendarAll.json)

2) GET /calendar/{country}/{month}/{year}

    Gets an array of days in month with specified country
    Example - http://localhost:8080/calendar/11/2022
    Response - [response](response/calendarCountry.json)

3) GET /calendar/current

    Gets an array of days in current month with current month from 2 countries US,IN
    Example - http://localhost:8080/calendar/current
    Response - [response](response/calendarCurrentAll.json)

4) GET /calendar/{country}/current

    Gets an array of days in current month with specified country
    Example - http://localhost:8080/calendar/IN/current
    Response - [response](response/calendarCurrentCountry.json)