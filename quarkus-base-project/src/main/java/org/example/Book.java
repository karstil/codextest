package org.example;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import org.example.Author;

@Entity
public class Book extends PanacheEntity {
    public String title;

    @ManyToOne
    public Author author;
}
