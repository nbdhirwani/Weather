package au.com.exercise.weather.business;

import au.com.exercise.weather.business.model.WeatherInformation;
import au.com.exercise.weather.openweathermap.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherService {


    @Value("${weather.api.endpoint}")
    private String endpoint;

    @Value("${weather.api.updatedDateTimePattern}")
    private String updatedDateTimePattern;

    @Autowired
    private RestOperations restTemplate;

    public WeatherInformation getWeatherInformation(String cityName) {

        Report report = getWeatherReport(cityName);
        return WeatherInformation
                .builder()
                .cityName(cityName)
                .weather(report.getWeather().get(0).getMain())
                .temperature(report.getMain().getTemp())
                .windSpeed(report.getWind().getSpeed())
                .updatedTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern(updatedDateTimePattern)))
                .build();
    }

    private Report getWeatherReport(String cityName) {

        return (Report) restTemplate.getForObject(endpoint.concat(cityName), Report.class);
    }
}
