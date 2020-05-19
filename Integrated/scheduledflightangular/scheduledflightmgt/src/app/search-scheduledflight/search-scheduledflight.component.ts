import { Component, OnInit } from '@angular/core';
import { ScheduledFlight } from '../model/scheduledflight';
import { ScheduledFlightService } from '../services/scheduledflightservice';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-search-scheduledflight',
  templateUrl: './search-scheduledflight.component.html',
  styleUrls: ['./search-scheduledflight.component.css']
})
export class SearchScheduledflightComponent implements OnInit {

  service: ScheduledFlightService;

  foundSchedule: ScheduledFlight = null;
  foundStatus = null;

  constructor(service: ScheduledFlightService) {
    this.service = service;
  }


  toDateTime(mili){
    let date = new Date(mili);
    return date;
  }

  ngOnInit(): void {
  }



  fetchByFlightNumber(form: any): void {
    let details = form.value;
    let flightnumber = details.flightnumber;
    let fetched: Observable<ScheduledFlight> = this.service.fetchByFlightNumber(flightnumber);
    fetched.subscribe(
      schedule => {
        this.foundSchedule = schedule;
        this.foundStatus = "found";
      },
      err => {
        this.foundStatus = "notfound";
        console.log("err while fetching schedules=" + err);
      }
    );

  }

}
