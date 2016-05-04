package au.com.exercise.weather.repository;

import au.com.exercise.weather.repository.model.CityEntity;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<CityEntity, Integer> {
}
