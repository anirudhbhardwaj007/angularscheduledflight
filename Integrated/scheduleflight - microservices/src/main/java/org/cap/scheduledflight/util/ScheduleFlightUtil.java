package org.cap.scheduledflight.util;

import org.cap.scheduledflight.dto.ScheduledFlightDetailsDto;
import org.cap.scheduledflight.entities.Schedule;
import org.cap.scheduledflight.entities.ScheduledFlight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleFlightUtil {

    private static final Logger Log = LoggerFactory.getLogger(ScheduleFlightUtil.class);


    public static List<ScheduledFlightDetailsDto>scheduleFlightDetails(List<ScheduledFlight>scheduledFlights){
        List<ScheduledFlightDetailsDto>desired=new ArrayList<>();
        for (ScheduledFlight scheduledFlight:scheduledFlights){
           ScheduledFlightDetailsDto details= scheduleFlightDetails(scheduledFlight);
           desired.add(details);
        }
        return desired;
    }

    public static ScheduledFlightDetailsDto scheduleFlightDetails(ScheduledFlight scheduledFlight) {

        ScheduledFlightDetailsDto scheduledFlightDetailsDto = new ScheduledFlightDetailsDto();
        scheduledFlightDetailsDto.setAvailableSeats(scheduledFlight.getAvailableSeats());

        scheduledFlightDetailsDto.setFlightNumber(scheduledFlight.getFlightNumber());

        Schedule schedule=scheduledFlight.getSchedule();
        //Airport
        // Aiport airport = fetchAirportbyAirportCode(airportCode);2
        scheduledFlightDetailsDto.setSourceAirport(schedule.getSourceAirportName());
        scheduledFlightDetailsDto.setDestinationAirport(schedule.getDestinationAirportName());

       LocalDateTime arrivalDateTime=schedule.getArrivalDateTime();
        long arrivalDateMillis= DateUtil.millis(arrivalDateTime);
        scheduledFlightDetailsDto.setArrivalTime(arrivalDateMillis);

        LocalDateTime departureDateTime=schedule.getDeparturedatetime();
        long departureDateMillis= DateUtil.millis(departureDateTime);
        scheduledFlightDetailsDto.setDepartureTime(departureDateMillis);



        return scheduledFlightDetailsDto;
    }









}
