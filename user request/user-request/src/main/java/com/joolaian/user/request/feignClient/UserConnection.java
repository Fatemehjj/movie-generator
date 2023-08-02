package com.joolaian.user.request.feignClient;

import com.joolaian.user.request.model.Movies;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("MOVIES-SERVICE")
public interface UserConnection {
    @GetMapping("movie/Category/{category}")
    public ResponseEntity<List<Movies>> getByCategory(@PathVariable String category);
    @GetMapping("movie/scale/{imdb}/{numOfQues}")
    public ResponseEntity<List<Movies>> getByScale(@PathVariable double imdb, @PathVariable int numOfQues);
    @GetMapping("movie/byScale&Cat/{category}/{imdb}/{numOfQues}")
    public ResponseEntity<List<Movies>> getByScaleAndCategory(@PathVariable String category,@PathVariable double imdb, @PathVariable int numOfQues);
    @GetMapping("movie/random/{number}")
    public ResponseEntity<List<Movies>> getRandomMovies(@PathVariable int number);
    @GetMapping("movie/Length/{length}")
    public ResponseEntity<List<Movies>> getByLength(@PathVariable int length);
    @GetMapping("movie/name/{name}")
    public ResponseEntity<List<Movies>> getByName(@PathVariable String name);
    @GetMapping("movie/release/{date}")
    public ResponseEntity<List<Movies>> getByReleaseDate(@PathVariable int date);
}
