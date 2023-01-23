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

import com.tweteroo.api.service.UserService;
import com.tweteroo.api.dto.UserDto;
import com.tweteroo.api.model.UserModel;

@RestController
@RequestMapping("/sign-up")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<UserModel> listAll() {
        return service.findAll();
    }

    @PostMapping
    public void postUser(@RequestBody UserDto req) {
        service.save(req);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDto req) {
        service.update(id, req);
    }
}
