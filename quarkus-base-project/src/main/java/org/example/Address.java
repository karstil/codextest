package org.example;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Address extends PanacheEntity {
    public String street;
    public String city;
    public String country;
}
