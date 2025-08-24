package techverito.application;

import techverito.constants.Messages;
import techverito.model.User;
import techverito.service.UserRequestProcessor;
import techverito.util.Logging;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Main application class , which receives input from user on console and calls service for further processing.
 */
public class D2H {

    static Scanner scanner = new Scanner(System.in);
    static UserRequestProcessor processor;

    public static void main(String[] args) {
        processor = new UserRequestProcessor(new InputReader());
        User user = new User();
        Logging.displayMessage(Messages.welcomeMessage);

        String input = "";
        do {
            Logging.displayLineSeprator();
            Logging.displayMessage(Messages.selectOption);
            input = getInput();
            processInput(input, user);
        } while (!input.equals("7"));

    }

    private static void processInput(String input, User user) {
        processor.process(input, user);
    }


    /*
     * Scanner for parsing simple input
     */
    public static String getInput() {

        return scanner.nextLine();
    }

    /*
     * Scanner for parsing channels list
     */
    public static List<String> getChannelsInput() {
        String value = scanner.nextLine();
        return Arrays.asList(value.split(","));
    }
}
