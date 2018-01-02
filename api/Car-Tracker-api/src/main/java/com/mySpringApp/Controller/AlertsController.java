package com.mySpringApp.Controller;


import com.mySpringApp.Entity.Alerts;
import com.mySpringApp.Service.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@ResponseBody
public class AlertsController {

    @Autowired
    AlertsService alertsService;

    //Mapping to get alerts of all vehicles
    @RequestMapping(method= RequestMethod.GET, value="/alerts")
    public List<Alerts> findAllAlerts()
    {
         return alertsService.findAllAlerts();
    }

     //Mapping to get alerts grouped by vin
    @RequestMapping(method= RequestMethod.GET, value="/alerts/{vin}")
    public Alerts findAlertsofVehicle( @PathVariable("vin") String vin)
    {
            return alertsService.findAlertsofVehicle(vin);
    }

    //Mapping for creating Alerts
    @RequestMapping(method=RequestMethod.POST, value="/alerts")
    public Alerts createAlerts(@RequestBody Alerts alerts)
    {
        return alertsService.createAlerts(alerts);
    }
}
