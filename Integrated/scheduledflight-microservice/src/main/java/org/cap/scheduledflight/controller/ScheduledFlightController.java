package org.cap.scheduledflight.controller;

import org.cap.scheduledflight.dto.CreateScheduleRequest;
import org.cap.scheduledflight.dto.ScheduledFlightDetailsDto;
import org.cap.scheduledflight.entities.Schedule;
import org.cap.scheduledflight.entities.ScheduledFlight;
import org.cap.scheduledflight.exceptions.ScheduledFlightNotFoundException;
import org.cap.scheduledflight.service.IScheduledFlightService;
import org.cap.scheduledflight.util.ScheduleFlightUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/scheduledflights")
public class ScheduledFlightController {
    private static final Logger Log = LoggerFactory.getLogger(ScheduledFlightController.class);

    @Autowired
    private IScheduledFlightService scheduledFlightService;


    @PostMapping("/add")
    public ResponseEntity<ScheduledFlightDetailsDto> createScheduledFlightRequest(@RequestBody CreateScheduleRequest requestdata) {

        ScheduledFlight scheduledFlight = new ScheduledFlight();
        scheduledFlight.setFlightNumber(requestdata.getFlightNumber());
        scheduledFlight.setAvailableSeats(requestdata.getAvailableseats());

        Schedule schedule = new Schedule();
        scheduledFlight.setSchedule(schedule);


        long arrivalMillis = requestdata.getArrivalTime();
        LocalDateTime arrivalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(arrivalMillis), ZoneId.systemDefault());
        schedule.setArrivalDateTime(arrivalDateTime);


        long departureMillis = requestdata.getDepartureTime();
        LocalDateTime departureDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(departureMillis), ZoneId.systemDefault());
        schedule.setDeparturedatetime(departureDateTime);


        schedule.setDestinationAirportName(requestdata.getDestinationAirport());
        schedule.setSourceAirportName(requestdata.getSourceAirport());


        scheduledFlightService.addscheduledFlight(scheduledFlight);
        ScheduledFlightDetailsDto scheduledFlightDetailsDto = ScheduleFlightUtil.scheduleFlightDetails(scheduledFlight);
        ResponseEntity<ScheduledFlightDetailsDto> response = new ResponseEntity<>(scheduledFlightDetailsDto, HttpStatus.OK);
        return response;
    }


    @GetMapping("/get/{flightnumber}")
    public ResponseEntity<ScheduledFlightDetailsDto> getScheduledflightsByflightnumber(@PathVariable("flightnumber") BigInteger flightnumber) {
        ScheduledFlight scheduledFlight = scheduledFlightService.viewScheduledFlights(flightnumber);
        ScheduledFlightDetailsDto details = ScheduleFlightUtil.scheduleFlightDetails(scheduledFlight);
        ResponseEntity<ScheduledFlightDetailsDto> response = new ResponseEntity<>(details, HttpStatus.OK);
        return response;
    }


    @GetMapping("/fetch/srcdest/{src}/{dest}/{date}")
    public ResponseEntity<List<ScheduledFlight>> fetchFlightsbetweenSrcandDest(@PathVariable String src,
                                                                               @PathVariable String dest,
                                                                               String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate arrivalDate = LocalDate.parse(date, formatter);
        List<ScheduledFlight> scheduledFlights = scheduledFlightService.viewScheduledFlights(src, dest, arrivalDate);
        ResponseEntity<List<ScheduledFlight>> response = new ResponseEntity<>(scheduledFlights, HttpStatus.OK);
        return response;
    }


    @DeleteMapping("/delete/{flightnumber}")
    public ResponseEntity<Boolean> deleteScheduleByFlightNumber(@PathVariable("flightnumber") BigInteger flightnumber) {
        ScheduledFlight scheduledFlight = scheduledFlightService.viewScheduledFlights(flightnumber);
        ResponseEntity<Boolean> response;
        if (scheduledFlight != null) {
            Boolean result = scheduledFlightService.deleteScheduledFlight(flightnumber);
            response = new ResponseEntity<>(result, HttpStatus.OK);

        } else
            response = new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
        return response;
    }


    @GetMapping
    public ResponseEntity<List<ScheduledFlightDetailsDto>> fetchScheduledFlights() {
        List<ScheduledFlight> scheduledFlights = scheduledFlightService.viewScheduledFlight();
        List<ScheduledFlightDetailsDto> scheduledFlightDetails = ScheduleFlightUtil.scheduleFlightDetails(scheduledFlights);
        ResponseEntity<List<ScheduledFlightDetailsDto>> response = new ResponseEntity<>(scheduledFlightDetails, HttpStatus.OK);
        return response;
    }

    @PutMapping("/modify/{flightnumber}")
    public ResponseEntity<ScheduledFlightDetailsDto> modify(@PathVariable("flightnumber") BigInteger flightNumber,
                                                     @Valid @RequestBody CreateScheduleRequest dto) {
        ScheduledFlight scheduledFlight = scheduledFlightService.viewScheduledFlights(flightNumber);
        scheduledFlight.setAvailableSeats(dto.getAvailableseats());
        Schedule schedule = new Schedule();
        scheduledFlight.setSchedule(schedule);
        schedule.setSourceAirportName(dto.getSourceAirport());
        schedule.setDestinationAirportName(dto.getDestinationAirport());


        long arrivalMillis = dto.getArrivalTime();
        LocalDateTime arrivalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(arrivalMillis), ZoneId.systemDefault());
        schedule.setArrivalDateTime(arrivalDateTime);

        long departureMillis = dto.getDepartureTime();
        LocalDateTime departureDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(departureMillis), ZoneId.systemDefault());
        schedule.setDeparturedatetime(departureDateTime);


        scheduledFlight = scheduledFlightService.modifyScheduledFlight(scheduledFlight);
        ScheduledFlightDetailsDto scheduledFlightDetailsDto = ScheduleFlightUtil.scheduleFlightDetails(scheduledFlight);
        ResponseEntity<ScheduledFlightDetailsDto> response = new ResponseEntity<>(scheduledFlightDetailsDto, HttpStatus.OK);
        return response;

    }


    @ExceptionHandler(ScheduledFlightNotFoundException.class)
    public ResponseEntity<String> handleScheduleFlightNotFound(ScheduledFlightNotFoundException ex) {
        Log.error("Schedule Flight Not Found ", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
        return response;
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolate(ConstraintViolationException ex) {
        Log.error("constraint violation", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleAll(Throwable ex) {
        Log.error("Something went wrong", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }


}

