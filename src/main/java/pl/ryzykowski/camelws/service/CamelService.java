package pl.ryzykowski.camelws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.camelws.exception.CamelNotFoundException;
import pl.ryzykowski.camelws.model.Camel;
import pl.ryzykowski.camelws.repository.CamelRepository;

import java.util.List;

@Service
public class CamelService {

    CamelRepository camelRepository;

    @Autowired
    public CamelService(CamelRepository camelRepository) {
        this.camelRepository = camelRepository;
    }

    public List<Camel> getCamels(){
        return camelRepository.findAll();
    }

    public List<Camel> getCamelsByGender(Camel.Gender gender){
        return camelRepository.findCamelsByGender(gender);
    }

    public Camel getCamel(Long id){
        return camelRepository.findById(id).orElseThrow(CamelNotFoundException::new);
    }

    public Camel addCamel(Camel camel){
        return camelRepository.save(camel);
    }

    public void deleteCamel(Long id){
        camelRepository.deleteById(id);
    }

    public Camel updateCamel(Camel camel){
        return camelRepository.save(camel);
    }
}
