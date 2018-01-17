import { Component, OnInit } from '@angular/core';
import {VehicleServiceService} from '../vehicle-service/vehicle-service.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-alert-details',
  templateUrl: './alert-details.component.html',
  styleUrls: ['./alert-details.component.css']
})
export class AlertDetailsComponent  {

  alerts: any;
  constructor(private route: ActivatedRoute, private vehicleService: VehicleServiceService) {

    this.route.params.subscribe(params =>
    {
      vehicleService.getAlertsById(params.vin)
        .subscribe(alerts => this.alerts = JSON.parse(JSON.stringify(alerts)));
    });
    }
  }

