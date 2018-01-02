package com.mySpringApp.Service;

import com.mySpringApp.Entity.Alerts;
import com.mySpringApp.Entity.Readings;
import com.mySpringApp.Entity.Tires;
import com.mySpringApp.Entity.Vehicles;
import com.mySpringApp.Exception.ResourceNotFound;
import com.mySpringApp.Repository.ReadingsRepository;
import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class ReadingsServiceImpl implements ReadingsService {

@Autowired
ReadingsRepository readingsRepository;
@Autowired
VehicleService vehicleService;
@Autowired
AlertsService alertsService;

   public Readings getReadingsofVehicle(String vin) {

       Readings r = readingsRepository.getReadingsofVehicle(vin);
       if(r==null)
       {
           throw new ResourceNotFound("Readings for vehicle with  vin " +vin+"doesn't exist");
       }

       return r;
   }

   @Transactional
    public Readings createReadings(Readings readings) {
       Readings r = readingsRepository.createReadings(readings);
       return r;
       }


       public void checkAlerts(Readings readings, Vehicles vehicles)
       {
           TimeZone tz = TimeZone.getTimeZone("UTC");
           DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
           df.setTimeZone(tz);
           String date = df.format(new Date());
           Tires tires = readings.getTires();
           int[] tirePressures = {tires.getFrontLeft(), tires.getFrontRight(), tires.getRearLeft(), tires.getRearRight()};
           if (readings.getEngineRpm() > vehicles.getRedlineRpm()) {
               Alerts alert = new Alerts();
               alert.setVin(vehicles.getVin());
               alert.setTimestamp(date);
               alert.setAlertReason("High RPM");
               alert.setAlertType("HIGH");
           }
           if (readings.getFuelVolume() < (0.1 * vehicles.getMaxFuelVolume())) {
               Alerts alert = new Alerts();
               alert.setVin(vehicles.getVin());
               alert.setTimestamp(date);
               alert.setAlertType("MEDIUM");
               alert.setAlertReason("Low Fuel Volume");
               alertsService.createAlerts(alert);

           }
           if (readings.isEngineCoolantLow() || readings.isCheckEngineLightOn()) {
               Alerts alert = new Alerts();
               alert.setVin(vehicles.getVin());
               alert.setTimestamp(date);
               alert.setAlertType("LOW");
               if (readings.isEngineCoolantLow())
                   alert.setAlertReason("Engine Coolant Low");
               else
                   alert.setAlertReason("Check Engine Light On");
               alertsService.createAlerts(alert);
           }
           for (int pressure : tirePressures) {
               if (pressure < 32 || pressure > 36) {
                   Alerts alert = new Alerts();
                   alert.setVin(vehicles.getVin());
                   alert.setTimestamp(date);
                   alert.setAlertType("LOW");
                   if (pressure < 32)
                   {alert.setAlertReason("Low Tire Pressure");}
                   else
                   {alert.setAlertReason("High Tire Pressure");}
                   alertsService.createAlerts(alert);
                   break;
               }
           }

       }
       }

