package com.app.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.twitter.entity.Tweet;
import com.app.twitter.entity.User;
import com.app.twitter.service.TweetService;
import com.app.twitter.service.UserService;

import java.util.List;

@Controller
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model) {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        User user = userService.findUserByUsername(username);
        List<Tweet> tweets = tweetService.findTweetsByUser(user);
        model.addAttribute("tweets", tweets);
        return "home";
    }

    @PostMapping("/tweet")
    public String createTweet(@RequestParam("content") String content) {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        User user = userService.findUserByUsername(username);
        Tweet tweet = new Tweet();
        tweet.setContent(content);
        tweet.setUser(user);
        tweetService.createTweet(tweet);
        return "redirect:/home";
    }
}
