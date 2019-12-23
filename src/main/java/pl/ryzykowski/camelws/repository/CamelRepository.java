package pl.ryzykowski.camelws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryzykowski.camelws.model.Camel;

import java.util.List;

public interface CamelRepository extends JpaRepository<Camel, Long> {

    List<Camel> findCamelsByGender(Camel.Gender gender);

}
