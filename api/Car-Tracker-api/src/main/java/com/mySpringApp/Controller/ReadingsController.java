package com.mySpringApp.Controller;

import com.mySpringApp.Entity.Readings;
import com.mySpringApp.Service.ReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Controller
@ResponseBody
/*If a method is annotated with @ResponseBody, Spring will bind the return value to outgoing HTTP response body.
 While doing that, Spring will [behind the scenes] use HTTP Message converters to convert the return value to HTTP
response body [serialize the object to response body], based on Content-Type present in request HTTP header.
 */
public class ReadingsController {

  @Autowired
 ReadingsService readingsService;

    //Mapping for getting readings of a particular vehicle
@RequestMapping(method= RequestMethod.GET, value="/readings/{vin}")
public Readings getReadingsofVehicle(@PathVariable("vin") String vin)
{
    return readingsService.getReadingsofVehicle(vin);
}

    //Mapping for post readings of vehicles
 @RequestMapping(method=RequestMethod.POST, value="/readings")
public Readings createReadings(@RequestBody Readings readings)
         /*if a method parameter is annotated with @RequestBody, Spring will bind the incoming HTTP request body
         to that parameter. While doing that, Spring will [behind the scenes] use HTTP Message converters to convert the HTTP request body
          into domain object [deserialize request body to domain object], based on Accept header present in request.
          */
{

    return readingsService.createReadings(readings);
}

}

