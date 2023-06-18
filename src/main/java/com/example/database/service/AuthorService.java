package com.example.database.service;

import com.example.database.domain.AuthorEntity;
import com.example.database.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public AuthorEntity save(AuthorEntity authorEntity) {
        authorRepository.saveOne(
                authorEntity.getName(),
                authorEntity.getAddress(),
                authorEntity.getUrl()
        );
        return authorEntity;
    }

    public List<Object[]> authInfo() {
        return authorRepository.authInfo();
    }

    public List<Object[]> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    public List<Object[]> getAuthorByName(String authorName) {
        return authorRepository.getAuthorByName(authorName);
    }
}
