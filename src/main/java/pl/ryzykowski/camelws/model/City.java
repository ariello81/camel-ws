package pl.ryzykowski.camelws.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    public City() {
    }

    public City(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @OneToMany(mappedBy = "from")
    @JsonIgnore
    private List<CamelRide> camelRideFrom;

    @OneToMany(mappedBy = "destination")
    @JsonIgnore
    private List<CamelRide> camelRideDestination;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<CamelRide> getCamelRideFrom() {
        return camelRideFrom;
    }

    public void setCamelRideFrom(List<CamelRide> camelRideFrom) {
        this.camelRideFrom = camelRideFrom;
    }

    public List<CamelRide> getCamelRideDestination() {
        return camelRideDestination;
    }

    public void setCamelRideDestination(List<CamelRide> camelRideDestination) {
        this.camelRideDestination = camelRideDestination;
    }
}
