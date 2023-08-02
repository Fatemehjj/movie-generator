package com.joolaian.movie.generator.dao;

import com.joolaian.movie.generator.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MoviesRepo extends JpaRepository<Movies, Integer> {
    List<Movies> findByCategory(String category);
    @Query(value ="SELECT * FROM movies q Where q.imdb>= :imdb ORDER BY RAND() LIMIT :numOfQues",nativeQuery = true)
    List<Movies> findByScaleAndLimitedByN(double imdb, int numOfQues);
    @Query(value ="SELECT * FROM movies q Where q.category= :category AND q.imdb>= :imdb ORDER BY RAND() LIMIT :numOfQues",nativeQuery = true)
    List<Movies> findByScaleAndCategory(String category, double imdb, int numOfQues);
    @Query(value = "SELECT * FROM movies ORDER BY RAND() LIMIT :number", nativeQuery = true)
    List<Movies> findRandomMovies(int number);
    List<Movies> findByLength(int len);
    @Query(value = "SELECT * FROM movies q WHERE q.length> :len", nativeQuery = true)
    List<Movies> findByLengthAndHigher(int len);
    @Query(value = "SELECT * FROM movies q WHERE q.movie_name LIKE (%:name%)", nativeQuery = true)
    List<Movies> findByConsistingName(String name);
    List<Movies> findByReleaseDate(int date);
}
