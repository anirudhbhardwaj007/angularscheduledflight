import { Component, OnInit } from '@angular/core';
import { ScheduledFlightService } from '../services/scheduledflightservice';
import { ScheduledFlight } from '../model/scheduledflight';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-modify-scheduledflight',
  templateUrl: './modify-scheduledflight.component.html',
  styleUrls: ['./modify-scheduledflight.component.css']
})
export class ModifyScheduledflightComponent implements OnInit {

  service: ScheduledFlightService;


  constructor(service: ScheduledFlightService) {
    this.service = service;
  }

  ngOnInit(): void {
  }

  modifiedSchedule: ScheduledFlight = null;

  modifySchedule(form: any) {
    let details = form.value;
    let flightnumber = details.flightnumber
    let sourceairport = details.sourceairport;
    let destinationairport = details.destinationairport;
    let departuretime=details.departuretime;
    let departuredate = new Date(departuretime);
    let departuretimemillis=departuredate.getTime();//departure time sent 
    let arrivaltime=details.arrivaltime;
    let arrivaldate = new Date(arrivaltime);
    let arrivaltimemillis=arrivaldate.getTime();//arrival time sent 
    let availableseats=details.availableseats;
   

    let schedules=new ScheduledFlight(flightnumber,sourceairport,destinationairport,departuretimemillis,arrivaltimemillis,availableseats);
    this.modifiedSchedule=schedules;
    let result = this.service.modifySchedule(schedules,flightnumber);

  
    result.subscribe((schedule: ScheduledFlight) => {

    },
      err => {
        console.log("err=" + err);
      });
    form.reset();
  }



}