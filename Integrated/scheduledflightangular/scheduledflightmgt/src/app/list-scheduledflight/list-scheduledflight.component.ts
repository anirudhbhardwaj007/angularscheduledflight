import { Component, OnInit } from '@angular/core';
import { ScheduledFlight } from '../model/scheduledflight';
import { ScheduledFlightService } from '../services/scheduledflightservice';
import { Observable, scheduled } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-scheduledflight',
  templateUrl: './list-scheduledflight.component.html',
  styleUrls: ['./list-scheduledflight.component.css']
})
export class ListScheduledflightComponent implements OnInit {

  schedules:ScheduledFlight[]=[];

  service:ScheduledFlightService;

  orderByField:string=null;

  constructor(service:ScheduledFlightService,private router:Router) {
    this.service=service;
 
    let observable:Observable<ScheduledFlight[]>=this.service.fetchAllSchedule();
    observable.subscribe(
      schs=>{
        this.schedules=schs;

       console.log("inside success callback ="+this.schedules.length);
       for(let schedule of schs){
          console.log(schedule.sourceAirport+"src"+schedule.availableSeats+"ava");
       }

      },
      err=>console.log(err)
      );
   }

   toDateTime(mili){
     let date = new Date(mili);
     return date;
   }

  ngOnInit(): void {
  }



  removeScheduleByFlightNumber(flightnumber:number){
    let result:Observable<boolean>=this.service.deleteScheduleByFlightNumber(flightnumber);
    result.subscribe(sch=>{
        this.removeLocalSchedule(flightnumber);
    },err=>{
     console.log("err in deleting="+err);
    })
      }



  removeLocalSchedule(flightnumber:number){
  let foundIndex=-1;
  for(let i=0;i<this.schedules.length;i++){
    let sch=this.schedules[i];
    if(sch.flightNumber===flightnumber){
      foundIndex=i;
      break;
    }
  }
  if(foundIndex<0){
    return;
  }
  this.schedules.splice(foundIndex,1);
}




//update

update()
{
  this.router.navigate(['../modify-scheduledflight'])
}
}
