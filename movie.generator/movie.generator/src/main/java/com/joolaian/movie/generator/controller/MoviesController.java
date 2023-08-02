package com.joolaian.movie.generator.controller;

import com.joolaian.movie.generator.model.Movies;
import com.joolaian.movie.generator.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("movie")
public class MoviesController {
    @Autowired
    MovieService service;
    @GetMapping("Category/{category}")
    public ResponseEntity<List<Movies>> getByCategory(@PathVariable String category){
        return service.findByCategory(category);
    }
    @GetMapping("scale/{imdb}/{numOfQues}")
    public ResponseEntity<List<Movies>> getByScale(@PathVariable double imdb, @PathVariable int numOfQues){
        return service.findByScale(imdb, numOfQues);
    }
    @GetMapping("byScale&Cat/{category}/{imdb}/{numOfQues}")
    public ResponseEntity<List<Movies>> getByScaleAndCategory(@PathVariable String category,@PathVariable double imdb, @PathVariable int numOfQues){
        return service.findByScaleAndCategory(category, imdb, numOfQues);
    }
    @GetMapping("random/{number}")
    public ResponseEntity<List<Movies>> getRandomMovies(@PathVariable int number){
        return service.findRandomMovies(number);
    }
    @GetMapping("Length/{length}")
    public ResponseEntity<List<Movies>> getByLength(@PathVariable int length){
        return service.findByLength(length);
    }
    @GetMapping("name/{name}")
    public ResponseEntity<List<Movies>> getByName(@PathVariable String name){
        return service.findByName(name);
    }
    @GetMapping("release/{date}")
    public ResponseEntity<List<Movies>> getByReleaseDate(@PathVariable int date){
        return service.findByReleaseDate(date);
    }
}
