package pl.ryzykowski.camelws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryzykowski.camelws.model.CamelRide;
import pl.ryzykowski.camelws.model.City;

import java.util.List;

public interface CamelRideRepository extends JpaRepository<CamelRide, Long> {

}
