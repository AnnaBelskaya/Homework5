package autoservice;

import java.util.Scanner;

public class MainClass {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.createCar();
    }
}
