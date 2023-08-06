package com.joolaian.user.request.dao;
import com.joolaian.user.request.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

   @Query(value = "SELECT * FROM user q WHERE q.title LIKE (%:title%) ", nativeQuery = true)
   List<User> findByTitle(String title);
   @Query(value = "SELECT * FROM user q WHERE q.title LIKE (%:title%) ORDER BY q.rating DESC LIMIT :range", nativeQuery = true)
   List<User> findTopReviews(int range, String title);
}
