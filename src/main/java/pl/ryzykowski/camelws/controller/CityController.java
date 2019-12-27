package pl.ryzykowski.camelws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ryzykowski.camelws.exception.CityNotFoundException;
import pl.ryzykowski.camelws.model.City;
import pl.ryzykowski.camelws.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> getCities(){
        return ResponseEntity.ok(cityService.getCities());
    }

    @GetMapping("/by")
    public ResponseEntity<List<City>> getCitiesByCountryName(@RequestParam String country){
        return ResponseEntity.ok(cityService.getCitiesByCountryName(country));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Long id){
        try {
            City city = cityService.getCity(id);
            return ResponseEntity.ok(city);
        }
        catch(CityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city){
        return ResponseEntity.ok(cityService.addCity(city));
    }

    @DeleteMapping("/{id}")
    public void deleteCityById(@PathVariable("id") Long id){
        cityService.deleteCity(id);
    }

    @DeleteMapping
    public void deleteCity(@RequestParam Long id){
        cityService.deleteCity(id);
    }

    @PutMapping
    public ResponseEntity<City> updateCity(@RequestBody City city){
        return ResponseEntity.ok(cityService.updateCity(city));
    }

}
