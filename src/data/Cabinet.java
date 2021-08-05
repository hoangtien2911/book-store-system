package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Cabinet {

    private ArrayList<Book> bookList = new ArrayList();

    public void addANewBook() {
        String author, name, publishingCompany, id;
        int yop; //year of publication
        double price;
        author = MyToys.getAString("Input name of author: ",
                                        "Please try again!!! Input a string.");
        name = MyToys.getAString("Input name of book: ", 
                                        "Please try again!!! Input a string.");
        publishingCompany = MyToys.getAString("Input name of publishing company: ",
                                        "Please try again!!! Input a string.");
        id = MyToys.getAString("Input id of book XXOOOOOO (X: Word, O: Number): ",
                                        "Please try again!!! Input XXOOOOOO (X: Word, O: Number).");
        yop = MyToys.getAnInteger("Input year of publication: ",
                                        "Please try again!!! Input an integer number.");
        price = MyToys.getADouble("Input price of book: ",
                                        "Please try again!!! Input a number.");
        bookList.add(new Book(author, name, publishingCompany, yop, id, price));
        System.out.println("Add a new book successfully!!!!");
    }

    public Book searchABookByID(String id) {
        if (bookList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equalsIgnoreCase(id)) {
                return bookList.get(i);
            }
        }
        return null;
    }

    public void searchABookByID() {
        String id;
        id = MyToys.getAString("Input ID you want to search: ",
                                    "Book id is required! Please input XXOOOOOO (X: Word, O: Number).");
        Book xxx = searchABookByID(id);
        if (xxx == null) {
            System.out.println("Book not found!!!");
        } else {
            System.out.println("Book found!!! There is: ");
            xxx.showBookInformation();
        }
    }

    public void updateABookByDiscountPrice() {
        double discount, price;
        String id;
        id = MyToys.getAString("Input id your book you want to update by discount price: ", 
                                    "Book id is required! Please input XXOOOOOO (X: Word, O: Number).");
        Book xxx = searchABookByID(id);
        if (xxx == null) {
            System.out.println("Book not found!!!");
            return;
        } else {
            System.out.println("Book found before update price!!! There is: ");
            xxx.showBookInformation();
        }
        discount = MyToys.getADouble("Input your discount of book: ",
                                            "Please try again!!! Input a number.");
        price = xxx.getPrice() * discount / 100;
        xxx.setPrice(price);
        System.out.println("Price of book after update by discount price: ");
        xxx.showBookInformation();
    }

    public void sortingByPrice() {
        for (int i = 0; i < bookList.size() - 1; i++) {
            for (int j = i + 1; j < bookList.size(); j++) {
                if (bookList.get(i).getPrice() < bookList.get(j).getPrice()) {
                    Book tmp = bookList.get(i);
                    bookList.set(i, bookList.get(j));
                    bookList.set(j, tmp);
                }
            }
        }
    }

    public void printTheBookList() {
        if (bookList.isEmpty()) {
            System.out.println("The book list is empty!!! Nothing to print.");
            return;
        }
        System.out.println("There is/are " + bookList.size() + " book(s):");
        sortingByPrice();
        for (Book x : bookList) {
            x.showBookInformation();
        }
    }
}
