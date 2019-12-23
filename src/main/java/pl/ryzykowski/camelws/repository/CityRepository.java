package pl.ryzykowski.camelws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryzykowski.camelws.model.City;

import java.util.List;

public interface CityRepository extends JpaRepository<Long, City> {

    public List<City> findCitiesByCountryIgnoreCase(String country);

}
