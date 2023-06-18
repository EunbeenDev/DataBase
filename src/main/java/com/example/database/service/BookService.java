package com.example.database.service;

import com.example.database.domain.AuthorEntity;
import com.example.database.domain.BookEntity;
import com.example.database.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Object[]> totBookPrice() {
        return bookRepository.totBookPrice();
    }

    public List<Object[]> yearBookPrice() {
        return bookRepository.yearBookPrice();
    }

    public BookEntity save(BookEntity bookEntity) {
        bookRepository.saveOne(
                bookEntity.getIsbn(),
                bookEntity.getTitle(),
                bookEntity.getYear(),
                bookEntity.getPrice()
        );
        return bookEntity;
    }

    @Transactional
    public void applySale(int quantity, float saleRatio) {
        bookRepository.applySale(quantity, saleRatio);
    }

    public List<Object[]> getAppliedBooks(int quantity) {
        return bookRepository.getAppliedBooks(quantity);
    }

}
