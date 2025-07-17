package com.itc.book_store.services;

import com.itc.book_store.entity.Book;
import com.itc.book_store.Bookrepository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor Injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setPublisher(updatedBook.getPublisher());
                    book.setIsbn(updatedBook.getIsbn());
                    book.setCategory(updatedBook.getCategory());
                    book.setDescription(updatedBook.getDescription());
                    book.setPrice(updatedBook.getPrice());
                    book.setStock(updatedBook.getStock());
                    book.setCoverImageUrl(updatedBook.getCoverImageUrl());
                    book.setPublicationDate(updatedBook.getPublicationDate());
                    book.setAvailable(updatedBook.isAvailable());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }
}
