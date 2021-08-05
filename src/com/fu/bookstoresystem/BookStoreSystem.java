
package com.fu.bookstoresystem;

import data.Cabinet;
import ui.Menu;


public class BookStoreSystem {

    public static void main(String[] args) {
        Menu menu = new Menu("Book Shop - ©2021 Copyright by <SE160239 - Phạm Hoàng Tiến>");
        menu.addNewOption("1. Add a book to the list");
        menu.addNewOption("2. Search a book by ID");
        menu.addNewOption("3. Update a specific book (price by discount) based on ID");
        menu.addNewOption("4. Print the book list in the descending order of Price");
        menu.addNewOption("5. Quit");
        Cabinet cage = new Cabinet();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are preparing to "
                            + "input a new book.");
                    cage.addANewBook();
                    break;
                case 2:
                    System.out.println("You are required to input "
                            + "a book id to search.");
                    cage.searchABookByID();
                    break;
                case 3:
                    System.out.println("You are required to input "
                            + "a book id to update price by discount.");
                    cage.updateABookByDiscountPrice();
                    break;
                case 4:
                    System.out.println("You are preparing to "
                            + "print the book list descending by price.");
                    cage.printTheBookList();
                    break;
                case 5:
                    System.out.println("Bye bye, see you next time.");
                    break;
                default:
                    System.out.println("Please choice 1...5");
                    break;
            }
            
        } while (choice != 5);
        
    }
    
}
