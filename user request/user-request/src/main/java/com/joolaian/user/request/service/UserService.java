package com.joolaian.user.request.service;

import com.joolaian.user.request.dao.UserRepo;
import com.joolaian.user.request.feignClient.UserConnection;
import com.joolaian.user.request.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    @Autowired
    UserConnection connection;
    public ResponseEntity<String> saveReview(UserDto response) {
        try {
            User user = new User();
            if (response.getRating()>10){
                user.setRating(10);
                user.setTitle(response.getTitle());
            }
            else {
                user.setTitle(response.getTitle());
                user.setRating(response.getRating());
            }
            user.setReview(response.getReview());
            repo.save(user);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("can't save the review", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByCategory(String category) {
        try {
            return connection.getByCategory(category);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByScale(double imdb, int numOfQues) {
       try {
           return connection.getByScale(imdb, numOfQues);
       }catch (Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByCatAndScale(String category, double imdb, int numOfQues) {
        try {
            return connection.getByScaleAndCategory(category, imdb, numOfQues);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findRandomMovies(int number) {
        try {
            return connection.getRandomMovies(number);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByLength(int length) {
        try {
            return connection.getByLength(length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByName(String name) {
       try {
           return connection.getByName(name);
       }catch (Exception E){
           E.printStackTrace();
       }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<UserDto>> findReviewAndRate(String title) {
        try {
            List<UserDto> user = new ArrayList<>();
            List<User> reviewsAndRates = repo.findByTitle(title);
            for (User users : reviewsAndRates){
                UserDto dto = new UserDto();
                dto.setTitle(users.getTitle());
                dto.setRating(users.getRating());
                dto.setReview(users.getReview());

                user.add(dto);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<DtoForReview>> getByReview(String title) {
        try {
            List<DtoForReview> respond = new ArrayList<>();
            List<User> reviews = repo.findByTitle(title);
            for (User users : reviews) {
                DtoForReview dto = new DtoForReview();
                dto.setTitle(users.getTitle());
                dto.setReview(users.getReview());

                respond.add(dto);
            }
            return new ResponseEntity<>(respond, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<DtoForRate>> getByRating(String title) {
        try {
            List<DtoForRate> result = new ArrayList<>();
            List<User> reviews = repo.findByTitle(title);
            for (User users : reviews){
                DtoForRate dto = new DtoForRate();
                dto.setTitle(users.getTitle());
                dto.setScale(users.getRating());

                result.add(dto);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Movies>> findByReleaseDate(int date) {
       try {
           return connection.getByReleaseDate(date);
       }catch (Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<UserDto>> findTopReviews(int range, String title) {
         try {
             List<UserDto> res = new ArrayList<>();
             List<User> getReviews= repo.findTopReviews(range, title);
             for (User user: getReviews){
                 UserDto userDto = new UserDto();
                 userDto.setReview(user.getReview());
                 userDto.setRating(user.getRating());
                 userDto.setTitle(user.getTitle());

                 res.add(userDto);
             }
             return new ResponseEntity<>(res, HttpStatus.OK);
         }catch (Exception e){
             e.printStackTrace();
         }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
