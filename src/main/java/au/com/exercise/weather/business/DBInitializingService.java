package au.com.exercise.weather.business;

import au.com.exercise.weather.repository.model.CityEntity;
import au.com.exercise.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@Transactional
@Service
public class DBInitializingService {

    @Value("${cities.dataFile}")
    private String dataFile;

    @Value("${cities.valueDelimiter}")
    private String valueDelimiter;

    @Autowired
    private CityRepository cityRepository;

    @PostConstruct
    public void init() throws IOException {

        final BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(dataFile)));
        Arrays.asList(reader.readLine().split(valueDelimiter))
                .stream()
                .forEach(this::saveCity);
        reader.close();
    }

    private void saveCity(String cityName) {
        cityRepository.save(CityEntity.builder().cityName(cityName).build());
    }
}
