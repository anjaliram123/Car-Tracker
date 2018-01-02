package com.mySpringApp.Controller;

import com.mySpringApp.Entity.Vehicles;
import com.mySpringApp.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@ResponseBody
public class VehicleController {

    @Autowired
    VehicleService service;

    //Mapping for getting all the vehicles.
    @RequestMapping(method= RequestMethod.GET, value="/vehicles")
public List<Vehicles> findAll()
{

    return service.findAll();
}
//Mapping for getting the vehicles by vin
@RequestMapping(method=RequestMethod.GET, value="/vehicles/{vin}")
public Vehicles findOne(@PathVariable("vin") String vin)
{
  return service.findOne(vin);
}

 //Mapping for put(upsert) vehicles.
@RequestMapping(method=RequestMethod.PUT , value="/vehicles")
public Vehicles upsertVehicles(@RequestBody Vehicles v)
{

    return service.upsertVehicles(v);
}
@RequestMapping(method=RequestMethod.PUT, value="/vehicles/{vin}")
public Vehicles update(@PathVariable("vin")String vin,@RequestBody Vehicles v)
{
  return service.update(vin,v);
}

@RequestMapping(method=RequestMethod.DELETE , value="/vehicles/{vin}")
public void delete(@PathVariable("vin") String vin)
{
  service.delete(vin);
}
}
