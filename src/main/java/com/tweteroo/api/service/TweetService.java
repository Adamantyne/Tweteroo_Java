package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDto;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.repository.TweetRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;
    
    public void save(TweetDto req) {
        repository.save(new TweetModel(req));
    }

    public List<TweetModel> findAll() {
        return repository.findAll();
    }

    public Page<TweetModel> findPage(Pageable pageable) {
        int page = Integer.parseInt(pageable.getPageParameter());
        int size = Integer.parseInt(pageable.getSizeParameter());

        PageRequest pageRequest = PageRequest.of(page, size);

        return new PageImpl<>(repository.findAll(), pageRequest, size);
    }
}
