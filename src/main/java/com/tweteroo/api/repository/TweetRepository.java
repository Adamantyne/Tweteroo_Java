package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.TweetModel;

public interface TweetRepository extends JpaRepository<TweetModel, Long> {
    
}
