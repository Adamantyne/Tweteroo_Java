package com.tweteroo.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDto;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.service.TweetService;
import com.tweteroo.api.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetController {
    @Autowired
    private TweetService service;
    @Autowired
    private UserService userService;

    @GetMapping("/{page}/{size}")
    public Page<TweetModel> getTweets(@PathVariable int page, @PathVariable int size) {
        return service.findPage(page, size);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<TweetModel>> listTweetsByUser(@PathVariable String username) {
        if (userService.findByUsername(username).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(service.findAllByUsername(username));
        }
    }

    @PostMapping
    public ResponseEntity<String> postUser(@RequestBody TweetDto req) {
        if (userService.findByUsername(req.username()).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            service.save(req);
            return ResponseEntity.ok().body("ok");
        }
    }
}
