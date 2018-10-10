import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Airports} from '../../model/airport.model';
import {AirportService} from '../../service/airport.service';

@Component({
  selector: 'app-list-airport',
  templateUrl: './list-airport.component.html',
  styleUrls: ['./list-airport.component.css']
})
export class ListAirportComponent implements OnInit {

  airports: Airports[];

  constructor(private router: Router, private airportService: AirportService) { }

  ngOnInit() {
    this.airportService.getAirport()
      .subscribe( data => {
        this.airports = data;
      });
  }

  deleteAirport(airport: Airports): void {
    this.airportService.deleteAirport(airport.airportCode)
      .subscribe( data => {
        this.airports = this.airports.filter(u => u !== airport);
      });
  }

  editAirport(airport: Airports): void {
    localStorage.removeItem("editAirportId");
    localStorage.setItem("editAirportId", airport.airportCode.toString());
    this.router.navigate(['edit-airport']);
  }

}

