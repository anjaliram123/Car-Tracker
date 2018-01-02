package com.mySpringApp.Service;

import com.mySpringApp.Entity.Vehicles;
import com.mySpringApp.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;
    public List<Vehicles> findAll() {

        return repository.findAll();
    }

    public Vehicles findOne(String vin) {

        Vehicles v = repository.findOne(vin);
        if(v==null)
        {

        }
        return v;

    }
    @Transactional
    public Vehicles upsertVehicles (Vehicles v)
    {
        return repository.upsertVehicles(v);
    }
    @Transactional
    public Vehicles update(String vin, Vehicles v) {

        return repository.update(vin, v);
    }

    @Transactional
    public void delete(String vin) {

        repository.delete(vin);
    }

}
