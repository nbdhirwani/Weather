package au.com.exercise.weather.business;

import au.com.exercise.weather.business.model.WeatherInformation;
import au.com.exercise.weather.openweathermap.Main;
import au.com.exercise.weather.openweathermap.Report;
import au.com.exercise.weather.openweathermap.Weather;
import au.com.exercise.weather.openweathermap.Wind;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {

    private static final String UPDATED_DATE_TIME_PATTERN = "MMM dd yyyy";
    private static final String ENDPOINT = "/weather?q=";
    private static final String CITY_NAME = "Sydney";

    @InjectMocks
    private WeatherService weatherService;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void init() {
        setField(weatherService, "endpoint", ENDPOINT);
        setField(weatherService, "updatedDateTimePattern", UPDATED_DATE_TIME_PATTERN);
    }

    @Test
    public void test__getWeatherInformation() throws Exception {

        final Report report = Report.builder()
                .weather(Collections.singletonList(Weather.builder().main("Cloudy").build()))
                .main(Main.builder().temp("31").build())
                .wind(Wind.builder().speed("12").build())
                .build();

        when(restTemplate.getForObject(ENDPOINT.concat(CITY_NAME), Report.class)).thenReturn(report);
        final WeatherInformation actual = weatherService.getWeatherInformation(CITY_NAME);
        verify(restTemplate, times(1)).getForObject(ENDPOINT.concat(CITY_NAME), Report.class);
    }

}