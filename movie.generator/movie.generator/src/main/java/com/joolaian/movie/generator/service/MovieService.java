package com.joolaian.movie.generator.service;

import com.joolaian.movie.generator.dao.MoviesRepo;
import com.joolaian.movie.generator.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MovieService {
    @Autowired
    MoviesRepo repo;

    public ResponseEntity<List<Movies>> findByCategory(String category) {
        try {
            return new ResponseEntity<>(repo.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByScale(double imdb, int numOfQues) {
        try {
            return new ResponseEntity<>(repo.findByScaleAndLimitedByN(imdb, numOfQues), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByScaleAndCategory(String category, double imdb, int numOfQues) {

        try {
            return new ResponseEntity<>(repo.findByScaleAndCategory(category, imdb, numOfQues), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findRandomMovies(int number) {
        try {
            return new ResponseEntity<>(repo.findRandomMovies(number), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByLength(int length) {
        try {
            List<Movies> movies = repo.findByLength(length);
            List<Movies> moviesWithHigherLen = repo.findByLengthAndHigher(length);

            if (movies.size() == 0) {
                return new ResponseEntity<>(moviesWithHigherLen, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(movies, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByName(String name) {

        try {
            return new ResponseEntity<>(repo.findByConsistingName(name), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByReleaseDate(int date) {
        try {
            return new ResponseEntity<>(repo.findByDate(date), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

  }
