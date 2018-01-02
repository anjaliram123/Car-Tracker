package com.mySpringApp.Repository;

import com.mySpringApp.Entity.Readings;

import java.util.List;

public interface ReadingsRepository {

    public Readings getReadingsofVehicle(String vin);

    public Readings createReadings( Readings readings);

}
