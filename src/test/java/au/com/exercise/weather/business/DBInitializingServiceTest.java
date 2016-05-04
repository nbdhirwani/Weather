package au.com.exercise.weather.business;

import au.com.exercise.weather.repository.CityRepository;
import au.com.exercise.weather.repository.model.CityEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@RunWith(MockitoJUnitRunner.class)
public class DBInitializingServiceTest {

    @InjectMocks
    private DBInitializingService dbInitializingService;

    @Mock
    private CityRepository cityRepository;

    @Before
    public void setUp() {
        setField(dbInitializingService, "dataFile", "/cities.txt");
        setField(dbInitializingService, "valueDelimiter", ",");
    }

    @Test
    public void test__init() throws Exception {
        final CityEntity sydney = CityEntity.builder().cityName("Sydney").build();
        when(cityRepository.save(any(CityEntity.class))).thenReturn(sydney);
        dbInitializingService.init();
        verify(cityRepository, times(1)).save(sydney);
    }
}