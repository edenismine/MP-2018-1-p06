package fciencias.clutil;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClUtil is a utility class that provides several static methods that are useful for
 * decorating the terminal and obtaining valid input from a user.
 *
 * @author Luis Daniel Aragon Bermudez 416041271
 */
public class CLUtil {
    public static final String N = "\u001B[0m"; // resets terminal color
    public static final String R = "\u001B[91m"; // red, error.
    public static final String G = "\u001B[92m"; // green, success.
    public static final String Y = "\u001B[93m"; // yellow, prompt.
    public static final String C = "\u001B[96m"; // blue, display.
    private static final Scanner stdin = new Scanner(System.in);
    private static final PrintStream stdout = System.out;

    /**
     * Method that asks the user for a valid string using a custom message and
     * only admits String's that match the provided regular expression. It then
     * returns such valid String.
     *
     * @param regex   Regular expression to be matched.
     * @param message Custom message used to prompt the user for input.
     * @return the string provided by the user that matches {@code regex}.
     */
    public static String getValidString(String regex, String message) {
        boolean seen = false;
        String str;
        do {
            if (seen) {
                error("Invalid option, try again.");
                input(message);
            } else {
                input(message);
            }
            while (!stdin.hasNextLine()) {
                stdin.next();
            }
            str = stdin.nextLine();
            seen = true;
        } while (!str.matches(regex));
        return str;
    }

    /**
     * Method that extracts the capturing group with index {@code num} from a
     * given String, {@code searchSpace} using the provided regular expression
     * {@code regex}. Capturing groups are indexed from left to right, starting
     * at one. Group zero denotes the entire pattern.
     *
     * @param regex       Regular expression that will be use to match the provided
     *                    string.
     * @param searchSpace The string from which this method will attempt to extract a
     *                    matching group.
     * @param num         the index of the desired matching group.
     * @return the capturing group with index {@code num} or an empty String if
     * no such group exists.
     */
    public static String getGroup(String regex, String searchSpace, int num) {
        Matcher match = Pattern.compile(regex).matcher(searchSpace);
        if (match.find())
            try {
                return match.group(num);
            } catch (IndexOutOfBoundsException e) {
                return "";
            }
        return "";
    }

    /**
     * This method attempts to sleep for {@code millis} milliseconds.
     *
     * @param millis Amount of time the program should sleep for (in milliseconds).
     */
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            error("Something went very wrong, could not sleep.");
        }
    }

    /**
     * This method takes a String and prints an adorned version using a
     * descriptive color and adding the prefix "ERROR: ". It can be used to
     * signal errors to the user.
     *
     * @param message the String to be decorated.
     */
    public static void error(String message) {
        stdout.println(R + "ERROR: " + message + N);
    }

    /**
     * This method takes a String and prints an adorned version using a
     * descriptive color and adding the suffix "&gt;&gt; ". It can be used
     * to ask the user for input.
     *
     * @param message the String to be decorated.
     */
    public static void input(String message) {
        stdout.print(Y + message + ">> " + N);
    }

    /**
     * This method takes a String and prints an adorned version using a
     * descriptive color. It can be used to emphasize the String or to display
     * descriptive messages from successful processes.
     *
     * @param message the String to be decorated.
     */
    public static void success(String message) {
        stdout.println(G + message + N);
    }

    /**
     * This method takes a String and prints an adorned version using a
     * descriptive color. It can be used to emphasize the String or to display
     * descriptions or steps.
     *
     * @param message the String to be decorated.
     */
    public static void display(String message) {
        stdout.println(C + message + N);
    }

    /**
     * This method prints a header with a custom width and title.
     *
     * @param title Custom title.
     * @param cols  Custom width.
     */
    public static void header(String title, int cols) {
        StringBuilder ray = new StringBuilder("");
        for (int i = 0; i < cols; i++) {
            ray.append("=");
        }

        StringBuilder newTitle = new StringBuilder("");
        for (int i = 0; i < ((cols - title.length()) / 2); i++) {
            newTitle.append(" ");
        }
        newTitle.append(title);
        for (int i = 0; i < ((cols - title.length()) / 2); i++) {
            newTitle.append(" ");
        }

        display(ray.toString());
        display(newTitle.toString());
        display(ray.toString());
    }

    /**
     * This method clears the terminal.
     */
    public static void flush() {
        stdout.print("\033[H\033[2J");
        stdout.flush();
    }
}
