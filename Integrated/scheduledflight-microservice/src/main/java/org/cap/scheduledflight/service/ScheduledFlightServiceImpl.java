package org.cap.scheduledflight.service;


import org.cap.scheduledflight.dao.IScheduleDao;
import org.cap.scheduledflight.dao.IScheduledFlightDao;
import org.cap.scheduledflight.entities.Schedule;
import org.cap.scheduledflight.entities.ScheduledFlight;
import org.cap.scheduledflight.exceptions.InvalidArgumentException;
import org.cap.scheduledflight.exceptions.ScheduledFlightNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ScheduledFlightServiceImpl implements IScheduledFlightService {

    @Autowired
    private IScheduledFlightDao scheduledFlightDao;

    @Autowired
    private IScheduleDao scheduleDao;


    @Override
    public ScheduledFlight addscheduledFlight(ScheduledFlight scheduledFlight) {
        if (scheduledFlight == null) {
            throw new InvalidArgumentException("Scheduleflight cannot be null ");
        }
        Schedule schedule = scheduledFlight.getSchedule();
        scheduleDao.save(schedule);
        scheduledFlight = scheduledFlightDao.save(scheduledFlight);
        return scheduledFlight;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlights(String sourceArg, String destinationArg, LocalDate time) {
        List<ScheduledFlight> list = scheduledFlightDao.findBySourceAndDestination(sourceArg, destinationArg, time);
        return list;

    }


    public ScheduledFlight findbyflightnumber(BigInteger flightNumber) {
        if (flightNumber == null) {
            throw new InvalidArgumentException("Flight number can't be null");
        }
        List<ScheduledFlight> scheduledFlights = scheduledFlightDao.findByFlightNumber(flightNumber);
        if (scheduledFlights.isEmpty()) {
            throw new ScheduledFlightNotFoundException("Schedule Not found for flight number +" + flightNumber);
        }
        ScheduledFlight flight = scheduledFlights.get(0);
        return flight;

    }

    @Override
    public ScheduledFlight viewScheduledFlights(BigInteger flightNumber) {
        ScheduledFlight scheduledFlight = findbyflightnumber(flightNumber);
        return scheduledFlight;

    }

    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        List<ScheduledFlight> scheduledFlight = scheduledFlightDao.findAll();
        return scheduledFlight;
    }


    @Override
    public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) {
        if (scheduledFlight == null) {
            throw new InvalidArgumentException("Scheduleflight cannot be Null ");
        }
        Schedule schedule = scheduledFlight.getSchedule();
        scheduleDao.save(schedule);
        scheduledFlight = scheduledFlightDao.save(scheduledFlight);
        return scheduledFlight;
    }


    @Override
    public Boolean deleteScheduledFlight(BigInteger flightNumber) {
        if (flightNumber == null) {
            throw new InvalidArgumentException("Flight Number Cannot be null");
        }
        ScheduledFlight flight = findbyflightnumber(flightNumber);
        scheduledFlightDao.delete(flight);
        return true;
    }


}



