package org.cap.scheduledflight.dto;

import java.math.BigInteger;

public class CreateScheduleRequest {

    private int availableSeats;
    private BigInteger flightNumber;
    private BigInteger scheduleid;

    private long arrivalTime;
    private long departureTime;

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    private String sourceAirport;
    private String destinationAirport;





    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }




    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }


    public BigInteger getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(BigInteger scheduleid) {
        this.scheduleid = scheduleid;
    }


    

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public int getAvailableseats() {
        return availableSeats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableSeats = availableseats;
    }


    public BigInteger getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(BigInteger flightNumber) {
        this.flightNumber = flightNumber;
    }


}

