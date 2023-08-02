package com.joolaian.user.request.model;
import lombok.Data;
@Data
public class Movies {
   // private int position;
    private String movie_name;
    private String category;
    private int length;
    private double imdb;
    private int releaseDate; //the names should be the same as the table in other microservice
}
