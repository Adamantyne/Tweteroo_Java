package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import com.tweteroo.api.model.TweetModel;

public interface TweetRepository extends JpaRepository<TweetModel, Long> {
    // @Query("SELECT * FROM Tweets WHERE username = ?1")
    List<TweetModel> findByUsername(String username);
}
