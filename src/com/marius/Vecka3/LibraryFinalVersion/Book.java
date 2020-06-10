package com.marius.Vecka3.LibraryFinalVersion;

import java.io.Serializable;


public class Book extends LibraryItem implements Serializable {

    //private static final long serialVersionUID = -4176451700479531040L;

    private String title, author, isbn, description, nameOfOccupyingReader;

    public Book(int id, String title,  String author, String isbn, String description) {
        super.setId(id);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.nameOfOccupyingReader = "";
    }

    public Book() {
        super.setId(0);
        title = null;
        author = null;
        this.nameOfOccupyingReader = "";
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameOfOccupyingReader() {
        return nameOfOccupyingReader;
    }

    public void setNameOfOccupyingReader(String nameOfOccupyingReader) {
        this.nameOfOccupyingReader = nameOfOccupyingReader;
    }

    public String bookExtendedInfo() {
        return "Title: " + title
                + " , Author: " + author
                + " , Id: " + super.getId()
                + " , Isbn:" + isbn
                + " , description: " + description;
    }

    // Book klasės toString() metodas handlina vienos knygos visos informacijos atvaizdavimą
    @Override
    public String toString() {
        return "Title: " + title + " , Author: " + author + " , Id: " + super.getId();
    }
}

