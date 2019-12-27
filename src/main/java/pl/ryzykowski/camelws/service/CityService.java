package pl.ryzykowski.camelws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.camelws.exception.CityNotFoundException;
import pl.ryzykowski.camelws.model.City;
import pl.ryzykowski.camelws.repository.CityRepository;

import java.util.List;

@Service
public class CityService {

    CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCities(){
        return cityRepository.findAll();
    }

    public List<City> getCitiesByCountryName(String country){
        return cityRepository.findCitiesByCountryIgnoreCase(country);
    }

    public City getCity(Long id){
        return cityRepository.findById(id).orElseThrow(CityNotFoundException::new);
    }

    public City addCity(City city){
        return cityRepository.save(city);
    }

    public void deleteCity(Long id){
        cityRepository.deleteById(id);
    }

    public City updateCity(City city){
        return cityRepository.save(city);
    }
}
