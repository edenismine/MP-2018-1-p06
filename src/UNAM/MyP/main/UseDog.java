package UNAM.MyP.main;

import java.util.Objects;
import java.util.Scanner;


public class UseDog {


    public static void main(String[] args) {


        Dog p = new Dog();
        Scanner input = new Scanner(System.in);

        int option;
        do {
            System.out.println("Choose what you want to do with your pet:");
            System.out.println("1. pet it");
            System.out.println("2. kick it");
            System.out.println("3. exit");
            option = input.nextInt();
            switch (option) {
                case 1:
                    p.setMood("happy");
                    break;
                case 2:
                    p.setMood("angry");
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
            }
            if (Objects.equals(p.mood, "happy")) {
                p.play();
                p.eat();
            } else {
                p.attack();
            }
        } while (option != 3);

    }

}