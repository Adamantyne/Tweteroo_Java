package com.tweteroo.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDto;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.service.TweetService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetController {
    @Autowired
    private TweetService service;

    @GetMapping("/{username}")
    public Page<TweetModel> getTweets(@PageableDefault(page = 0, size = 5) Pageable page) {
        return service.findPage(page);
    }

    @GetMapping
    public List<TweetModel> listAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void postTweet(@RequestBody TweetDto req) {
        service.save(req);
    }
}
