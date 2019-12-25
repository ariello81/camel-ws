package pl.ryzykowski.camelws.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class CamelRide {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="city_from_id")
    private City from;

    @ManyToOne
    @JoinColumn(name="city_destination_id")
    private City destination;

    @ManyToOne
    @JoinColumn(name="camel_id")
    private Camel camel;

    private Timestamp departureDate;

    private Timestamp arrivalDate;

    public CamelRide() {
    }

    public CamelRide(Long id, City from, City destination, Camel camel, Timestamp departureDate, Timestamp arrivalDate) {
        this.id = id;
        this.from = from;
        this.destination = destination;
        this.camel = camel;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getFrom() {
        return from;
    }

    public void setFrom(City from) {
        this.from = from;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public Camel getCamel() {
        return camel;
    }

    public void setCamel(Camel camel) {
        this.camel = camel;
    }

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
