package pl.ryzykowski.camelws.model;

import javax.persistence.Entity;

@Entity
public class Camel {

    private Long id;
    private int age;
    private double capacity;
    private String name;
    private Gender gender;

    public enum Gender {MALE, FEMALE}

    ;

    public Camel() {
    }

    private Camel(Long id, int age, double capacity, String name, Gender gender) {
        this.id = id;
        this.age = age;
        this.capacity = capacity;
        this.name = name;
        this.gender = gender;
    }
}
