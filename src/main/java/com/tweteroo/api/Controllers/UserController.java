package com.tweteroo.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.service.UserService;
import com.tweteroo.api.dto.UserDto;
import com.tweteroo.api.model.UserModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sign-up")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserModel>> listAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void postUser(@RequestBody UserDto req) {
        service.save(req);
    }
}
