package au.com.exercise.weather.controller;

import au.com.exercise.weather.business.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/allcities", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<String> getAllAvailableCities() {
        return cityService.findAllAvailableCities();
    }
}
