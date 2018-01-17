import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import {VehicleServiceService} from './vehicle-service/vehicle-service.service';
import { FormsModule } from '@angular/forms';
import { AlertDetailsComponent } from './alert-details/alert-details.component';
import { GeoLocationComponent } from './geo-location/geo-location.component';
import {AgmCoreModule} from '@agm/core';

const appRoutes: Routes = [
  { path: 'vehicles', component: VehicleListComponent },
  {path: 'vehicles/:vin'  , component: VehicleDetailsComponent},
  {path: 'alerts/:vin', component: AlertDetailsComponent},
  {path: 'location/:vin', component: GeoLocationComponent},
  { path: '', redirectTo: '/vehicles', pathMatch: 'full' },
];
@NgModule({
  declarations: [
    AppComponent,
    VehicleListComponent,
    VehicleDetailsComponent,
    AlertDetailsComponent,
    GeoLocationComponent
  ],
  imports: [
    AgmCoreModule.forRoot({apiKey: 'AIzaSyD791QVKRrDCotXDMTdsNS-SpPQs7c6Nlk'}),
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [VehicleServiceService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
