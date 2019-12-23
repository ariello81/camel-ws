package pl.ryzykowski.camelws.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Camel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int age;
    private double capacity;
    private String name;
    private Gender gender;

    @OneToMany(mappedBy="camel")
    @JsonIgnore
    private List<CamelRide> camelRides;

    public enum Gender {MALE, FEMALE};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<CamelRide> getCamelRides() {
        return camelRides;
    }

    public void setCamelRides(List<CamelRide> camelRides) {
        this.camelRides = camelRides;
    }
}
