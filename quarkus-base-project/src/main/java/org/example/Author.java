package org.example;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Author extends PanacheEntity {
    public String name;

    @OneToOne
    public Address address;
}
