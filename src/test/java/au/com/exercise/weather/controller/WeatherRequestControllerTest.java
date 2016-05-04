package au.com.exercise.weather.controller;

import au.com.exercise.weather.business.WeatherService;
import au.com.exercise.weather.business.model.WeatherInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherRequestControllerTest {

    public static final String CITY_NAME = "Sydney";

    @InjectMocks
    private WeatherRequestController weatherRequestController;

    @Mock
    private WeatherService weatherService;

    @Test
    public void test__getWeatherInformation() throws Exception {
        final WeatherInformation sydneyWeather = WeatherInformation.builder().cityName(CITY_NAME).build();
        when(weatherService.getWeatherInformation(CITY_NAME)).thenReturn(sydneyWeather);
        weatherRequestController.getWeatherInformation(CITY_NAME);
        verify(weatherService, times(1)).getWeatherInformation(CITY_NAME);
    }

}