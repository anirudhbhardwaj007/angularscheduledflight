package org.cap.scheduledflight.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue
    private int scheduleId;

    private String sourceAirportName;
    private String destinationAirportName;
    private LocalDateTime arrivalDateTime;
    private LocalDateTime departureDateTime;


    public LocalDateTime getDeparturedatetime() {
        return departureDateTime;
    }

    public void setDeparturedatetime(LocalDateTime departuredatetime) {
        this.departureDateTime = departuredatetime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getSourceAirportName() {
        return sourceAirportName;
    }

    public void setSourceAirportName(String sourceAirportName) {
        this.sourceAirportName = sourceAirportName;
    }

    public String getDestinationAirportName() {
        return destinationAirportName;
    }

    public void setDestinationAirportName(String destinationAirportName) {
        this.destinationAirportName = destinationAirportName;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }


}
