import { Component } from '@angular/core';
import { } from 'googlemaps';
import {VehicleServiceService} from '../vehicle-service/vehicle-service.service';
import {ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-geo-location',
  styleUrls: ['./geo-location.component.css'],
  template : `

    <agm-map [latitude]="readings?.latitude" [longitude]="readings?.longitude">
      <agm-marker [latitude]="readings?.latitude" [longitude]="readings?.longitude"></agm-marker>
    </agm-map>
    <a [routerLink]="['/vehicles']" class="btn btn-primary">Go Back</a>
  `
})

export class GeoLocationComponent {
  readings: any;
  public latitude: string | number;
  public longitude: string | number;

  constructor(private route: ActivatedRoute, private vehicleService: VehicleServiceService)
  {

    this.route.params.subscribe(params =>
    {
      vehicleService.getLocationById(params.vin)
        .subscribe(readings => this.readings = readings);
    });
  }
}
