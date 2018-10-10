import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Airports} from '../model/airport.model';

@Injectable()
export class AirportService {
  constructor(private http: HttpClient) { }
  baseUrl = 'http://localhost:8080/airports';

  getAirport() {
    return this.http.get<Airports[]>(this.baseUrl+'/');
  }

  getAirportById(id: number) {
    return this.http.get<Airports>(this.baseUrl + '/' + id);
  }

  createAirport(airports: Airports) {
    return this.http.post(this.baseUrl, airports);
  }

  updateAirport(airports: Airports) {
    return this.http.put(this.baseUrl + '/' + airports.airportCode, airports);
  }

  deleteAirport(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }
}
