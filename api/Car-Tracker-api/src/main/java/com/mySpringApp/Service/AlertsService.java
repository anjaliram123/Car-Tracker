package com.mySpringApp.Service;


import com.mySpringApp.Entity.Alerts;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface AlertsService
{

    public List<Alerts> findAllAlerts();

    public Alerts findAlertsofVehicle( @PathVariable("vin") String vin);

    public Alerts createAlerts(Alerts alerts);

}
