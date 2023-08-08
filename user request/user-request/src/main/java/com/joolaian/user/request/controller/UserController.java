package com.joolaian.user.request.controller;

import com.joolaian.user.request.model.*;
import com.joolaian.user.request.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("review")
    public ResponseEntity<String> saveReview(@RequestBody UserDto response) {
        return service.saveReview(response);
    }
    @GetMapping("category/{cat}")
    public ResponseEntity<List<Movies>> getByCategory(@PathVariable("cat") String category) {
        return service.findByCategory(category);
    }
    @PostMapping("byScale")
    public ResponseEntity<List<Movies>> getByScale(@RequestBody DtoForResponse response) {
        return service.findByScale(response.getImdb(), response.getNumOfMovies());
    }
    @PostMapping("scaleAndCat")
    public ResponseEntity<List<Movies>> getByScaleAndCategory(@RequestBody DtoForCat user){
       return service.findByCatAndScale(user.getCategory(), user.getImdb(), user.getNumOfMovies());
    }
    @GetMapping("random/{variety}")
    public ResponseEntity<List<Movies>> getRandomMovies(@PathVariable(value = "variety") int number){
        return service.findRandomMovies(number);
    }
    @GetMapping("length/{length}")
    public ResponseEntity<List<Movies>> getByLength(@PathVariable int length){
        return service.findByLength(length);
    }
    @GetMapping("name/{name}")
    public ResponseEntity<List<Movies>> getByName(@PathVariable String name){
        return service.findByName(name);
    }
    @GetMapping("reviewAndRating/{title}")
    public ResponseEntity<List<UserDto>> getReviewAndRating(@PathVariable String title){
        return service.findReviewAndRate(title);
    }
    @GetMapping("getReview/{title}")
    public ResponseEntity<List<DtoForReview>> getReview(@PathVariable String title){
        return service.getByReview(title);
    }
    @GetMapping("getRating/{title}")
    public ResponseEntity<List<DtoForRate>> getRating(@PathVariable String title){
        return service.getByRating(title);
    }
    @GetMapping("release/{date}")
    public ResponseEntity<List<Movies>> getByReleaseDate(@PathVariable int date){
        return service.findByReleaseDate(date);
    }
    @GetMapping("top/{range}/{title}")
    public ResponseEntity<List<UserDto>> getTopReviews(@PathVariable int range, @PathVariable String title){
        return service.findTopReviews(range, title);
    }
    @GetMapping("all")
    public ResponseEntity<List<Movies>> getAllMovies(){
     return service.findAllMovies();
    }
}
