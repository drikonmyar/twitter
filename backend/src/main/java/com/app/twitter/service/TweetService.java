package com.app.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.twitter.entity.Tweet;
import com.app.twitter.entity.User;
import com.app.twitter.repository.TweetRepository;

import java.util.List;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }
    
    public List<Tweet> findTweetsByUser(User user) {
        return tweetRepository.findByUser(user);
    }
}
