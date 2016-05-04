package au.com.exercise.weather.business;

import au.com.exercise.weather.repository.CityRepository;
import au.com.exercise.weather.repository.model.CityEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

    private static final String CITY_NAME = "Sydney";
    @InjectMocks
    private CityService cityService;

    @Mock
    private CityRepository cityRepository;

    @Test
    public void test__findAllAvailableCities() throws Exception {

        when(cityRepository.findAll()).thenReturn(Collections.singletonList(CityEntity.builder().cityName("Sydney").build()));
        final List<String> actual = cityService.findAllAvailableCities();
        verify(cityRepository, times(1)).findAll();
        assertThat(actual, equalTo(Collections.singletonList(CITY_NAME)));
    }
}