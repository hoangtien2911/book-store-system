/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Hp
 */
public class Book {
    private String author;
    private String name;
    private String publishingCompany;
    private int yop; //year of publication
    private String id;
    private double price;

    public Book(String author, String name, String publishingCompany, int yop, String id, double price) {
        this.author = author;
        this.name = name;
        this.publishingCompany = publishingCompany;
        this.yop = yop;
        this.id = id;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public int getYop() {
        return yop;
    }

    public void setYop(int yop) {
        this.yop = yop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("|%-30s|%-30s|%-30s|%4d|%-8s|%5.2f|\n",
                                                                author, name, publishingCompany, yop, id, price);
    }
    public void showBookInformation() {
        System.out.printf("|%-30s|%-30s|%-30s|%4d|%-8s|%5.2f|\n",
                                                                author, name, publishingCompany, yop, id, price);
    }
}
