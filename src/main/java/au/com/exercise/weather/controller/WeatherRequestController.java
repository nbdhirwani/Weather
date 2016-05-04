package au.com.exercise.weather.controller;

import au.com.exercise.weather.business.model.WeatherInformation;
import au.com.exercise.weather.business.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class WeatherRequestController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/weather/{city}", method = GET, produces = APPLICATION_JSON_VALUE)
    public WeatherInformation getWeatherInformation(@PathVariable("city") final String cityName) {
        return  weatherService.getWeatherInformation(cityName);
    }
}
