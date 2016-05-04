package au.com.exercise.weather.controller;

import au.com.exercise.weather.business.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityControllerTest {

    @InjectMocks
    private CityController cityController;

    @Mock
    private CityService cityService;

    @Test
    public void test__getAllAvailableCities() throws Exception {
        when(cityService.findAllAvailableCities()).thenReturn(Collections.emptyList());
        final List<String> actual = cityController.getAllAvailableCities();
        verify(cityService, times(1)).findAllAvailableCities();
    }
}