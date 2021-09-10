package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Cabinet {

    private ArrayList<Book> bookList = new ArrayList();

    public void addANewBook() {
        String author, name, publishingCompany, id;
        int yop; //year of publication
        int pos; //lưu vị trí tìm thấy id
        double price;
        author = MyToys.getAString("Input name of author: ",
                "Please try again!!! Input a string.");

        name = MyToys.getAString("Input name of book: ",
                "Please try again!!! Input a string.");

        publishingCompany = MyToys.getAString("Input name of publishing company: ",
                "Please try again!!! Input a string.");

        do {
            id = MyToys.getID("Input id of book BOOOO (O stands for a digit): ",
                    "Please try again!!! Input BOOOO (O stands for a digit).", "^[B|b]\\d{4}$");
            pos = searchABookByIDForInput(id);
            if (pos >= 0)
                System.out.println("The book id already exists. "
                        + "Input another one!");
        } while (pos != -1);

        yop = MyToys.getAnInteger("Input year of publication(1990 - 2021): ",
                "Please try again!!! Input a number(1990-2021).", 1990, 2021);

        price = MyToys.getADouble("Input price of book(USD): ",
                "Please try again!!! Input a number.", 1, 1000);

        bookList.add(new Book(author, name, publishingCompany, yop, id, price));
        System.out.println("Add a new book successfully!!!!");
    }

    public int searchABookByIDForInput(String id) {
        if (bookList.isEmpty()) 
            return -1;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }

    public Book searchABookByID(String id) {
        if (bookList.isEmpty()) 
            return null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equalsIgnoreCase(id)) 
                return bookList.get(i);
        }
        return null;
    }

    public void searchABookByID() {
        String id;
        id = MyToys.getID("Input ID you want to search: ",
                    "Please try again!!! Input BOOOO (O stands for a digit).", "^[B|b]\\d{4}$");
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
        id = MyToys.getID("Input id your book you want to update by discount price: ",
                    "Please try again!!! Input BOOOO (O stands for a digit).", "^[B|b]\\d{4}$");
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

    public void removeABook() {
        String id;
        String answer;
        String yes = "YES", no = "NO";
        id = MyToys.getID("Input id your book you want to remove: ",
                    "Please try again!!! Input BOOOO (O stands for a digit).", "^[B|b]\\d{4}$");
        int xxx = searchABookByIDForInput(id);
        if (xxx == -1) {
            System.out.println("Book not found!!!");
            return;
        } else {
            System.out.println("Book found before remove!!! There is: ");
            bookList.get(xxx).showBookInformation();
        }
        answer = MyToys.getAString("Are you sure to remove? ", "Please input Yes or No!!!");
        if (answer.equalsIgnoreCase(yes)){
            bookList.remove(xxx);
            System.out.println("Book has been removed from the list");
        }
        if (answer.equalsIgnoreCase(no))
            System.out.println("Book will not be deleted!");
    }
}
