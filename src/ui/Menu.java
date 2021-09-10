package ui;

import data.MyToys;
import java.util.ArrayList;

public class Menu {

    private String menuTitle;
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
        String customer = MyToys.getAString("Login name: ", "Please input your name!!!");
        System.out.println("Hi " + customer);
        for (String x : optionList) {
            System.out.println(x);
        }
    }

    public int getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Your choice 1..." + maxOption + ": ";
        String errorMsg = "Please choice 1..." + maxOption + ".";
        return MyToys.getAnInteger(inputMsg, errorMsg, 1, maxOption);
    }
}
