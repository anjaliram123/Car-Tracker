package com.mySpringApp.Service;

import com.mySpringApp.Entity.Readings;

import java.util.List;

public interface ReadingsService
{
    public Readings getReadingsofVehicle(String vin);


    public Readings createReadings(Readings readings);

}
