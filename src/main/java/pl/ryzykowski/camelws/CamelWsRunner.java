package pl.ryzykowski.camelws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.ryzykowski.camelws.model.City;
import pl.ryzykowski.camelws.repository.CityRepository;

import java.util.Arrays;

@Service
public class CamelWsRunner implements CommandLineRunner {

    @Autowired
    CityRepository cityRepository;

    @Override
    public void run(String... args) throws Exception {
        cityRepository.saveAll(Arrays.asList(
                new City(1L, "Belchatow", "Poland"),
                new City(2L, "Vienna", "Austria"),
                new City(3L, "Prague", "Czech Republic")
        ));
    }
}
