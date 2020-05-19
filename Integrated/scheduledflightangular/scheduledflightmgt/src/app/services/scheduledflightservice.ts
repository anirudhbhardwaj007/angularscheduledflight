import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ScheduledFlight } from '../model/scheduledflight';
import { Observable, observable } from 'rxjs';

@Injectable()
export class ScheduledFlightService{
  client:HttpClient ;
  constructor(client:HttpClient ){
  this.client=client;
  }


  baseScheduledFlightUrl="http://localhost:8086/scheduledflights";



  addSchedule(sch:ScheduledFlight): Observable<ScheduledFlight>{
    let url=this.baseScheduledFlightUrl+"/add";
    console.log("flightnumber"+sch.flightNumber+"sourceairport"+sch.sourceAirport+"destair"+sch.destinationAirport+"departuretime"+sch.departureTime+"Arrival"+sch.arrivalTime);
    let result:Observable<ScheduledFlight>= this.client.post<ScheduledFlight>(url,sch);
    return result;
    }


    fetchByFlightNumber(flightNumber:number):Observable<ScheduledFlight>{
        let url=this. baseScheduledFlightUrl+'/get/'+flightNumber;
        let observable:Observable<ScheduledFlight> =this.client.get<ScheduledFlight>(url);
        return observable;  
      }



    fetchAllSchedule():Observable<ScheduledFlight[]>{
    let url=this. baseScheduledFlightUrl;
    let observable:Observable<ScheduledFlight[]> =this.client.get<ScheduledFlight[]>(url);
    return observable;
  }




  deleteScheduleByFlightNumber(flightnumber:number){
    let url=this.baseScheduledFlightUrl+"/delete/"+flightnumber;
    let result:Observable<boolean>=this.client.delete<boolean>(url);
    return result;
  }

  modifySchedule(schedule:ScheduledFlight,flightNumber:number):Observable<ScheduledFlight>{
    let url=this.baseScheduledFlightUrl+"/modify/"+flightNumber;
    let result:Observable<ScheduledFlight>= this.client.put<ScheduledFlight>(url,schedule);
    return result;
    }


}