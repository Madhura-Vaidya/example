package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;



@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }
    /*
    Save the book to the repository
     */
    public Book saveBook(String title, String author, LocalDate publishedDate, boolean isKidFriendly){
        /*
        Check if the book already exists else create a new book
         */
        return bookRepository.findByTitle(title)
                .orElse(bookRepository.save(new Book(title, author, publishedDate, isKidFriendly)));

    }
    /*
    Given a title for the book delete the book
     */
    public void deleteBook(String title) {

        bookRepository.delete(verifyBook(title));
    }

    public long count(){

        return bookRepository.count();
    }
    /*
    find all the books in the repository
     */
    public List<Book> findAllBooks() {

        return bookRepository.findAll();
    }

    /*
    Given name of author find books by author
     */
    public List<Book> findBooksByAuthor(String author){
        List<Book> booksByAuthor = bookRepository.findByAuthor(author);
        // If no books are present then show the message to the user
        if(booksByAuthor.size() == 0){
            throw new NoSuchElementException("Could not find any book by this author");
        }
        return booksByAuthor;
    }

    private Book verifyBook(String title) {
        return bookRepository.findByTitle(title)
                .orElseThrow(() -> new NoSuchElementException("No book found. Please give Valid  title."));
    }



}
