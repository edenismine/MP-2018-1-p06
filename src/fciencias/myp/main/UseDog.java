package fciencias.myp.main;

import fciencias.clutil.CLUtil;

import java.util.Scanner;

/**
 * Demo of the Dog class implemented using the state design pattern.
 *
 * @author Luis Daniel Aragon Bermudez 416041271
 */
public class UseDog {
    private static final String regex = "^(?i)(pet|kick|feed|exit)$";


    public static void main(String[] args) {
        Dog p = new Dog();
        Scanner input = new Scanner(System.in);
        char option;
        do {
            CLUtil.flush();
            System.out.println("Choose what you want to do with your pet:");
            System.out.println("> " + CLUtil.G + "pet" + CLUtil.N + " to pet it");
            System.out.println("> " + CLUtil.G + "kick" + CLUtil.N + " to kick it");
            System.out.println("> " + CLUtil.G + "feed" + CLUtil.N + " to feed it");
            System.out.println("> " + CLUtil.G + "exit" + CLUtil.N + " to exit the program");
            option = CLUtil.getValidString(regex, "input ").toLowerCase().charAt(0);
            switch (option) {
                case 'p':
                    p.pet();
                    break;
                case 'k':
                    p.kick();
                    break;
                case 'f':
                    p.feed();
                    break;
                case 'e':
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, try again!");
                    break;
            }
            CLUtil.sleep(2000);
        } while (option != 'e');

    }

}