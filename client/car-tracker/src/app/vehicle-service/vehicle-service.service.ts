import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class VehicleServiceService {

  vehicles;

  constructor(private http: Http) {

  }

  getVehicles(): Observable<any[]> {
    return this.http.get('http://localhost:50279/api/vehicles')
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  getDetailsById(vin): Observable<any[]> {
    return this.http.get(`http://localhost:50279/api/readings/${vin}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  getAlertsById(vin): Observable<any[]> {
    return this.http.get(`http://localhost:50279/api/alerts/${vin}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  getLocationById(vin): Observable<any>
  {
    return this.http.get(`http://localhost:50279/api/readings/${vin}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
}



