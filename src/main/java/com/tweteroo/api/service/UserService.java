package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDto;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<UserModel> findAll() {
        return repository.findAll();
    }

    public void save(UserDto req) {
        repository.save(new UserModel(req));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, UserDto req) {
        repository.findById(id).map(user -> {
            user.setAvatar(req.avatar());
            user.setUsername(req.username());

            return repository.save(user);
        });
    }
}
