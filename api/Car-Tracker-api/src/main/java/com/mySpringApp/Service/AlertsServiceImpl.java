package com.mySpringApp.Service;


import com.mySpringApp.Entity.Alerts;
import com.mySpringApp.Exception.BadRequestException;
import com.mySpringApp.Exception.ResourceNotFound;
import com.mySpringApp.Repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlertsServiceImpl implements AlertsService {

    @Autowired
    AlertsRepository alertsRepository;


    @Transactional
    public List<Alerts> findAllAlerts() {

        return alertsRepository.findAllAlerts();
    }

    @Transactional
    public Alerts findAlertsofVehicle(String vin) {

        Alerts a =alertsRepository.findAlertsofVehicle(vin);
        if(a==null)
        {
            throw new ResourceNotFound("Vehicle with vin number" +vin+"doesn't exist");
        }
        return a;
        }

        @Transactional
    public Alerts createAlerts(Alerts alerts)
    {
        Alerts a =alertsRepository.createAlerts(alerts);

        return a;

    }
}
