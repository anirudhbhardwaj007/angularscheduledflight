package org.cap.scheduledflight.entities;


import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "scheduledflight")
public class ScheduledFlight {


    @Id
    @GeneratedValue
    private int schedule_Flight_Id;

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

    public int getSchedule_Flight_Id() {
        return schedule_Flight_Id;
    }

    public void setSchedule_Flight_Id(int schedule_Flight_Id) {
        this.schedule_Flight_Id = schedule_Flight_Id;


    }
}

