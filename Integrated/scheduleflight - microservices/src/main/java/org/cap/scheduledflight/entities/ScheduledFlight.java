package org.cap.scheduledflight.entities;


import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "scheduledflight")
public class ScheduledFlight {


    @Id
    @GeneratedValue
    private int schedule_flight_id;

    private BigInteger flightNumber;
    private int availableSeats;

    @OneToOne
    private Schedule schedule;


    public BigInteger getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(BigInteger flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }


    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getSchedule_flight_id() {
        return schedule_flight_id;
    }

    public void setSchedule_flight_id(int schedule_flight_id) {
        this.schedule_flight_id = schedule_flight_id;


    }
}

