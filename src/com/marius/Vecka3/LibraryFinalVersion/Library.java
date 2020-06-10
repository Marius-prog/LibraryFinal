package com.marius.Vecka3.LibraryFinalVersion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {


    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private String usersFilename = "users.ser";
    private String booksFilename = "books.ser";

    public Library() {
        loadUsersFile();
        loadBooksFile();
    }

    public void addBook(Book book) {
        books.add(book);
        this.saveBooks();
    }

    public void deleteBook(int idx) {
        books.remove(idx);
        this.saveBooks();
    }

    public void printAllBooks() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void printAllBooksInfo() {
        for (Book book : books) {
            System.out.println(book.bookExtendedInfo());
        }
    }

    public int checkIfBookExistsAndReturnIdx(int id) {
        Book book;
        for (int i = 0; i < books.size(); i++) {
            book = books.get(i);
            if (book.getId() == id)
                return i;
        }
        return -1;
    }

    public void addUser(User user) {
        users.add(user);
        this.saveUsers();
    }

    public void deleteUser(int idx) {
        users.remove(idx);
        this.saveUsers();
    }

    public void printAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public int checkIfUserExistsAndReturnIdx(int id) {
        User user;
        for (int i = 0; i < users.size(); i++) {
            user = users.get(i);
            if (user.getUserId() == id)
                return i;
        }
        return -1;
    }


    public Book getBookById(int id) {
        Book bookUnderInvestigation = null;
        for (int i = 0; i < books.size(); i++) {
            bookUnderInvestigation = books.get(i);
            if (bookUnderInvestigation.getId() == id)
                return bookUnderInvestigation;
        }
        return bookUnderInvestigation;
    }

    @Override
    public String toString() {
        String total = "\n";
        for (Book book : books)
            System.out.println(book);
        // Library klasė handlina visų knygų dalinės infor atvaizdavimą
        // System.out.println("Title: " + book.getTitle() + " , author:" + book.getTitle() ... ir t.t. );
        return total;
    }

    private void saveUsers() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(usersFilename);
            out = new ObjectOutputStream(fos);
            out.writeObject(users);
            fos.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveBooks() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(booksFilename);
            out = new ObjectOutputStream(fos);
            out.writeObject(books);
            fos.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUsersFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        File file = new File(usersFilename);
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                users = (List<User>) in.readObject();
                fis.close();
                in.close();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\nfile does not exist!");
        }
    }

    private void loadBooksFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        File file = new File(booksFilename);
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                books = (List<Book>) in.readObject();
                fis.close();
                in.close();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\nfile does not exist!");
        }
    }
}

