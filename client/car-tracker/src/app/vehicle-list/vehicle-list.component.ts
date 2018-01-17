import { Component, OnInit } from '@angular/core';
import {VehicleServiceService} from '../vehicle-service/vehicle-service.service';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent  {

  vehicles;
  constructor(private vehicleService: VehicleServiceService) {

    vehicleService.getVehicles()
      .subscribe(
        vehicles => this.vehicles = vehicles,
        error =>  console.log(error)
      );


  }
}
