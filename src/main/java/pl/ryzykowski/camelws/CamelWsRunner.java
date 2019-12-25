package pl.ryzykowski.camelws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.ryzykowski.camelws.model.Camel;
import pl.ryzykowski.camelws.model.CamelRide;
import pl.ryzykowski.camelws.model.City;
import pl.ryzykowski.camelws.repository.CamelRepository;
import pl.ryzykowski.camelws.repository.CamelRideRepository;
import pl.ryzykowski.camelws.repository.CityRepository;

import java.sql.Timestamp;
import java.util.Arrays;

@Service
public class CamelWsRunner implements CommandLineRunner {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CamelRepository camelRepository;

    @Autowired
    CamelRideRepository camelRideRepository;

    @Override
    public void run(String... args) throws Exception {
        City city1 = new City(1L, "Belchatow", "Poland");
        City city2 = new City(2L, "Vienna", "Austria");
        City city3 = new City(3L, "Prague", "Czech Republic");
        cityRepository.saveAll(Arrays.asList(city1, city2, city3));

        Camel camel1 = new Camel(1L, 38, 75.2d, "Ariel", Camel.Gender.MALE);
        Camel camel2 = new Camel(2L, 35, 59.3d, "Anna", Camel.Gender.FEMALE);
        Camel camel3 = new Camel(3L, 11, 34.6d, "Kuba", Camel.Gender.MALE);
        Camel camel4 = new Camel(4L, 5, 16.8d, "Iga", Camel.Gender.FEMALE);
        camelRepository.saveAll(Arrays.asList(camel1, camel2, camel3, camel4));

        camelRideRepository.saveAll(Arrays.asList(
                new CamelRide(1L, city1, city2, camel1,
                        Timestamp.valueOf("2018-12-01 23:00:00"), Timestamp.valueOf("2018-12-02 08:00:00")),
                new CamelRide(2L, city2, city1, camel2,
                        Timestamp.valueOf("2018-12-02 17:00:00"), Timestamp.valueOf("2018-12-03 01:00:00")),
                new CamelRide(3L, city1, city3, camel2,
                        Timestamp.valueOf("2018-11-10 23:00:00"), Timestamp.valueOf("2018-11-11 22:00:00")),
                new CamelRide(4L, city1, city3, camel3,
                        Timestamp.valueOf("2019-04-07 07:00:00"), Timestamp.valueOf("2019-04-08 15:00:00")),
                new CamelRide(5L, city3, city1, camel4,
                        Timestamp.valueOf("2018-04-09 16:00:00"), Timestamp.valueOf("2019-04-09 21:00:00"))
        ));
    }
}
