package au.com.exercise.weather.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "cities")
@EqualsAndHashCode(of = {"cityName"})
public class CityEntity {
    @GeneratedValue
    @Id
    private Integer id;
    private String cityName;
}
