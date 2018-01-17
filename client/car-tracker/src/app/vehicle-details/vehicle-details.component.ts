import { Component} from '@angular/core';
import {VehicleServiceService} from '../vehicle-service/vehicle-service.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css']
})
export class VehicleDetailsComponent  {

  readings: any;
  vehicles: any;

  constructor(private route: ActivatedRoute, private vehicleService: VehicleServiceService)
  {

    this.route.params.subscribe(params =>
    {
      vehicleService.getDetailsById(params.vin)
        .subscribe(readings => this.readings = readings);
  });
}}

