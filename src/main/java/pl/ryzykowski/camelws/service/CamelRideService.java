package pl.ryzykowski.camelws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.camelws.exception.CamelRideNotFoundException;
import pl.ryzykowski.camelws.model.CamelRide;
import pl.ryzykowski.camelws.repository.CamelRideRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CamelRideService {

    CamelRideRepository camelRideRepository;

    @Autowired
    public CamelRideService(CamelRideRepository camelRideRepository) {
        this.camelRideRepository = camelRideRepository;
    }

    public List<CamelRide> getCamelRides(){
        return camelRideRepository.findAll();
    }

    public List<CamelRide> getCamelRidesByFromCity(Long cityId){
        return camelRideRepository.findAll().stream()
                .filter(camelRide -> camelRide.getFrom().getId().equals(cityId)).collect(Collectors.toList());
    }

    public List<CamelRide> getCamelRidesByDestinationCity(Long cityId){
        return camelRideRepository.findAll().stream()
                .filter(camelRide -> camelRide.getDestination().getId().equals(cityId))
                .collect(Collectors.toList());
    }

    public CamelRide getCamelRideById(Long id){
        return camelRideRepository.findById(id).orElseThrow(CamelRideNotFoundException::new);
    }

    public CamelRide addCamelRide(CamelRide camelRide){
        return camelRideRepository.save(camelRide);
    }

    public void deleteCamelRide(Long id){
        camelRideRepository.deleteById(id);
    }

    public CamelRide updateCamelRide(CamelRide camelRide){
        return camelRideRepository.save(camelRide);
    }


}
