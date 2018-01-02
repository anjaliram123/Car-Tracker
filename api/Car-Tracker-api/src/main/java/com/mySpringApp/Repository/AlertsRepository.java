package com.mySpringApp.Repository;

import com.mySpringApp.Entity.Alerts;

import java.util.List;

public interface AlertsRepository {

    public List<Alerts>  findAllAlerts();

    public Alerts findAlertsofVehicle(String vin);

    public Alerts createAlerts(Alerts alerts);
}
