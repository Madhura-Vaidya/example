package com.example.controller;

import com.example.model.Book;
import com.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private BookService bookService;

    BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book.getTitle(), book.getAuthor(),
                book.getPublishedDate(), book.isKidFriendly());
    }

    @GetMapping
    public List<Book> findBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("{author}")
    public List<Book> findBooksByAuthor(@PathVariable (value="author") String author){
        return bookService.findBooksByAuthor(author);
    }

    @DeleteMapping("{title}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable (value ="title") String title){
        bookService.deleteBook(title);

    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);

    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Book partialUpdateBook(@RequestBody Book book){
        return bookService.partialUpdateBook(book.getBookNumber(), Optional.ofNullable(book.getTitle()), Optional.ofNullable(book.getAuthor()),
                Optional.ofNullable(book.getPublishedDate()), Optional.ofNullable(book.isKidFriendly()));

    }
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(NoSuchElementException exception){
        return exception.getMessage();
    }



}
