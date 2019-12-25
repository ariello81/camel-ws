package pl.ryzykowski.camelws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ryzykowski.camelws.exception.CamelRideNotFoundException;
import pl.ryzykowski.camelws.model.CamelRide;
import pl.ryzykowski.camelws.service.CamelRideService;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/camelRide")
public class CamelRideController {

    CamelRideService camelRideService;

    @Autowired
    public CamelRideController(CamelRideService camelRideService) {
        this.camelRideService = camelRideService;
    }

    @GetMapping
    public ResponseEntity<List<CamelRide>> getCamelRides(){
        return ResponseEntity.ok(camelRideService.getCamelRides());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CamelRide> getCamelRideById(@PathVariable("id") Long id){
        try {
            CamelRide camelRide = camelRideService.getCamelRideById(id);
            return ResponseEntity.ok(camelRide);
        }
        catch (CamelRideNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/from/{cityId}")
    public ResponseEntity<List<CamelRide>> getCamelRidesByFromCity(@PathVariable("cityId") Long cityId){
        return ResponseEntity.ok(camelRideService.getCamelRidesByFromCity(cityId));
    }

    @GetMapping("/destination/{cityId}")
    public ResponseEntity<List<CamelRide>> getCamelRidesByDestinationCity(@PathVariable("cityId") Long cityId){
        return ResponseEntity.ok(camelRideService.getCamelRidesByDestinationCity(cityId));
    }

}
