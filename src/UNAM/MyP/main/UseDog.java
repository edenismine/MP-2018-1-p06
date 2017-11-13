package UNAM.MyP.main;

import java.util.Scanner;

/**
 * Demo of the Dog class implemented using the state design pattern.
 *
 * @author Luis Daniel Aragon Bermudez 416041271
 */
public class UseDog {


    public static void main(String[] args) {
        Dog p = new Dog();
        Scanner input = new Scanner(System.in);

        int option;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Choose what you want to do with your pet:");
            System.out.println("1. pet it");
            System.out.println("2. kick it");
            System.out.println("3. feed it");
            System.out.println("4. exit");
            option = input.nextInt();
            switch (option) {
                case 1:
                    p.pet();
                    break;
                case 2:
                    p.kick();
                    break;
                case 3:
                    p.feed();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, try again!");
                    break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (option != 4);

    }

}