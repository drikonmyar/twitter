package com.app.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.twitter.entity.Tweet;
import com.app.twitter.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findByUser(User user);
}
