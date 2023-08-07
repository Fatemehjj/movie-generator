package com.joolaian.movie.generator.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@NoArgsConstructor
@Data
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int position;
    private String movie_name;
    private String category;
    private int length;
    private double imdb;
    @Column(name = "release_date")
    private int date;
}
