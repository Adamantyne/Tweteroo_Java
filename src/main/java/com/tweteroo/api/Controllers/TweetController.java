package com.tweteroo.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDto;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.repository.TweetRepository;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    @Autowired
    private TweetRepository repository;

    @GetMapping("/{username}")
    public List<TweetModel> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public void postTweet(@RequestBody TweetDto req) {
        repository.save(new TweetModel(req));
    }

    @DeleteMapping("/{id}")
    public void deleteTweet(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateTweet(@PathVariable Long id, @RequestBody TweetDto req) {
        repository.findById(id).map(tweet -> {
            tweet.setTweet((req.tweet()));
            tweet.setUsername(req.username());

            return repository.save(tweet);
        });
    }
}
