package com.mySpringApp.Repository;

import com.mySpringApp.Entity.Vehicles;

import java.util.List;

public interface VehicleRepository {
    List<Vehicles> findAll();

    Vehicles findOne(String vin);

    Vehicles upsertVehicles(Vehicles v);

    Vehicles update(String vin, Vehicles v);

    void delete(String vin);
}
