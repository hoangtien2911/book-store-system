package ui;

import data.MyToys;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private String menuTitle;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<String> optionList = new ArrayList();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }

    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no item in menu!!!");
            return;
        }
        System.out.println("\n----------------------");
        System.out.println("Welcome to " + menuTitle);
        System.out.print("Login name: ");
        String customer;
        customer = sc.nextLine().toUpperCase();
        System.out.println("Hi " + customer);
        for (String x : optionList) {
            System.out.println(x);
        }
    }
    public int getChoice() {
        int choice;
        choice = MyToys.getAnInteger("Your choice(1...5): ", "Please choice a number 1...5");
        return choice;
    }
}
