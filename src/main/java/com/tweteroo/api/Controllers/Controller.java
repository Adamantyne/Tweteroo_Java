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

import com.tweteroo.api.repository.UserRepository;
import com.tweteroo.api.dto.UserDto;
import com.tweteroo.api.model.UserModel;

@RestController
@RequestMapping("/sign-up")
public class Controller {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<UserModel> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public void postUser(@RequestBody UserDto req) {
        repository.save(new UserModel(req));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody UserDto req) {
        repository.findById(id).map(user -> {
            user.setAvatar(req.avatar());
            user.setUsername(req.username());

            return repository.save(user);
        });
    }
}
