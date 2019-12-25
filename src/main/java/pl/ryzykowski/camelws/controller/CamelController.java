package pl.ryzykowski.camelws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ryzykowski.camelws.exception.CamelNotFoundException;
import pl.ryzykowski.camelws.model.Camel;
import pl.ryzykowski.camelws.service.CamelService;

import java.util.List;

@RestController
@RequestMapping("/camel")
public class CamelController {

    private CamelService camelService;

    @Autowired
    public CamelController(CamelService camelService) {
        this.camelService = camelService;
    }

    @GetMapping
    public ResponseEntity<List<Camel>> getCamels(){
        return ResponseEntity.ok(camelService.getCamels());
    }

    @GetMapping("/by")
    public ResponseEntity<List<Camel>> getCamelsByGender(@RequestParam String gender){
        return ResponseEntity.ok(camelService.getCamelsByGender(Camel.Gender.valueOf(gender)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camel> getCamelById(@PathVariable("id") Long id){
        try {
            Camel camel = camelService.getCamel(id);
            return ResponseEntity.ok(camel);
        }
        catch (CamelNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
