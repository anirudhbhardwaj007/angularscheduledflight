export class ScheduledFlight{

    flightNumber:number;
    sourceAirport:string;
    destinationAirport:string;
    departureTime:number;
    arrivalTime:number;
    availableSeats:number;
   



constructor(flightNumber:number,sourceAirport:string,destinationAirport:string,departureTime:number,arrivalTime:number,availableSeats:number){
        this.flightNumber=flightNumber;
        this.sourceAirport=sourceAirport;
        this.destinationAirport=destinationAirport;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.availableSeats=availableSeats;
    
    }

}