package com.example.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
@Entity
@Table (name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookNumber;

    @Column(length = 50)
    private String title;
    @Column
    private String author;
    @Column
    private LocalDate publishedDate;
    @Column
    boolean isKidFriendly;

    public Book(){

    }

    public Book( String title, String author, LocalDate publishedDate, boolean isKidFriendly) {

        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.isKidFriendly = isKidFriendly;
    }

    public long getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(long bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public boolean isKidFriendly() {
        return isKidFriendly;
    }

    public void setKidFriendly(boolean kidFriendly) {
        isKidFriendly = kidFriendly;
    }



}
