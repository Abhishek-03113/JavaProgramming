package Exceptions;

public class NoAvailableDriverException extends Exception {
    public NoAvailableDriverException(String message) {
        super(message);
    }

    public NoAvailableDriverException(String message, Throwable cause) {
        super(message, cause);
    }


}

