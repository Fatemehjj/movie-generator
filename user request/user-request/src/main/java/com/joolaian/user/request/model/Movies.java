package com.joolaian.user.request.model;
import lombok.Data;
@Data
public class Movies {
   // private int position;
    private String movie_name;
    private String category;
    private int length;
    private double imdb;
    private int date; //the names should be same as the table in other microservice
}
