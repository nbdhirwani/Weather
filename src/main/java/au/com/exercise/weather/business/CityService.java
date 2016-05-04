package au.com.exercise.weather.business;

import au.com.exercise.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<String> findAllAvailableCities() {
        return StreamSupport.stream(cityRepository.findAll().spliterator(), false)
                .map(city -> city.getCityName())
                .collect(Collectors.toList());
    }
}
