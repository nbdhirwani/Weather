package au.com.exercise.weather.business.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class WeatherInformation {
    private String cityName;
    private String updatedTime;
    private String weather;
    private String temperature;
    private String windSpeed;
}
