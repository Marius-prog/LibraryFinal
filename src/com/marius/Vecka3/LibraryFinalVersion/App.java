package com.marius.Vecka3.LibraryFinalVersion;

import java.util.Scanner;

public class App {

    private static Library library = new Library();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String choice;
        do {
            String initialMenuOptions = "Press: \n"
                    + "\t- 1: librarian menu\n"
                    + "\t- 2: user menu\n"
                    + "\t- q: quit the program";
            System.out.println(initialMenuOptions);
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    handleLibrarian(sc);
                    break;
                case "2":
                    handleUser(sc);
                    break;
                case "q":
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                case "Q":
                    System.out.println("Bye!");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Incorrect value entered!");
            }
        } while (true);
    }

    private static void handleLibrarian(Scanner sc) {
        String choice;
        do {
            System.out.println("\nPress: \n"
                    + "\t- 1: users menu\n"
                    + "\t- 2: book menu");
            choice = sc.nextLine();
        } while (!choice.equals("1") && !choice.equals("2"));

        if (choice.equals("1")) librarianUsersMenu(sc);
        else librarianBooksMenu(sc);
    }

    private static void handleUser(Scanner sc) {
        String choice;
        do {
            System.out.println("\nPress: \n"
                    + "\t- 0: list all books in library\n"
                    + "\t- 1: for more information about a book\n"
                    + "\t- 2: to borrow a book\n"
                    + "\t- 3: search by title or author\n"
                    + "\t- 4: list books you borrowed\n"
                    + "\t- 5: return a book");
            choice = sc.nextLine();
        } while (!choice.equals("4") && !choice.equals("5") && !choice.equals("0") && !choice.equals("1") && !choice.equals("2") && !choice.equals("3"));

        if (choice.equals("0")) library.printAllBooks();
        else if (choice.equals("1")) library.printAllBooksInfo();
       // else if (choice.equals("2")) borrowABook();
      else if (choice.equals("3"));
            //       else if (choice.equals("4")) listOfYouBorrowedBooks();
//        else if (choice.equals("5")) returnBook();
        else handleUser(sc);
    }

    //private static void searchByTitleAndAuthor(String titel, String author) {


   // }

//    private static int borrowABook(String title, String author) {
//
//            int found = 0;
//            for (Book book : library.checkIfBookExistsAndReturnIdx())
//            {
//                if (book.getTitle().equals(title) && book.getAuthor().equals(author))
//                {
//                    if (found == 0)
//                    {
//                        found = 1;
//                    }
//                    if (!book.isBorrowed())
//                    {
//                        book.borrowed=true;
//                        found = 2;
//                        break;
//                    }
//                }
//            }
//
//            if (found == 0) {
//                System.out.println("Sorry, this book is not in our catalog.");
//            } else if (found == 1) {
//                System.out.println("Sorry, this book is already borrowed.");
//            } else if (found == 2) {
//                System.out.println("You successfully borrowed " + title);
//            }
//        }


    private static void librarianBooksMenu(Scanner sc) {
        String choice;
        do {
            System.out.println("\nPress: \n"
                    + "\t- 1: add book\n"
                    + "\t- 2: list all books\n"
                    + "\t- 3: remove book");
            choice = sc.nextLine();
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));

        if (choice.equals("1"))
            addBook(sc);
        else if (choice.equals("2"))
            library.printAllBooks();
        else
            deleteBook(sc);
    }

    private static void librarianUsersMenu(Scanner sc) {
        String choice;
        do {
            System.out.println("\nPress: \n"
                    + "\t- 1: add user\n"
                    + "\t- 2: list all users\n"
                    + "\t- 3: remove user");
            choice = sc.nextLine();
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));

        if (choice.equals("1"))
            addUser(sc);
        else if (choice.equals("2"))
            library.printAllUsers();
        else
            deleteUser(sc);
    }



    private static void addUser(Scanner sc) {
        System.out.println("\nEnter User's ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("\nEnter User's name: ");
        String name = sc.nextLine();

        System.out.println("\nEnter User's mobile number: ");
        int mobileNumber = sc.nextInt();
        sc.nextLine();

        User user = new User(name, id, mobileNumber);
        library.addUser(user);
    }

    private static void deleteUser(Scanner sc) {
        System.out.println("\nEnter User's ID: ");
        int id = sc.nextInt();    //????????????????????
        sc.nextLine();
        int idx = library.checkIfUserExistsAndReturnIdx(id);
        if (idx != -1) {
            library.deleteUser(idx);
            System.out.println("User deleted!");
        } else {
            System.out.println("User does not exist with this id!");
        }
    }

    private static void addBook(Scanner sc) {
        System.out.println("\nEnter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("\nEnter title: ");
        String title = sc.nextLine();

        System.out.println("\nEnter author: ");
        String author = sc.nextLine();

        System.out.println("\nEnter isbn: ");
        String isbn = sc.nextLine();

        System.out.println("\nEnter description: ");
        String description = sc.nextLine();

        Book book = new Book(id, title, author, isbn, description);
        library.addBook(book);
    }

    private static void deleteBook(Scanner sc) {
        System.out.println("\nEnter Book's ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        int idx = library.checkIfBookExistsAndReturnIdx(id);
        if (idx != -1) {
            library.deleteBook(idx);
            System.out.println("Book deleted!");
        } else {
            System.out.println("Book does not exist with this id!");
        }
    }
}

