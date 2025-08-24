package techverito.util;

/*
 * This class handles all console logs.
 */
public class Logging {


    private Logging() {

    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayMessage(String message, String value) {
        System.out.printf(message, value);
    }

    public static void displayNewLine() {
        System.out.println();
    }

    public static void displayLineSeprator() {
        System.out.println("====================================================");
    }
}
