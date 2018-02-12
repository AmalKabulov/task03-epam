package by.epam.parser.exception;

public class CouldNotReadException extends Exception {
    public CouldNotReadException() {
        super();
    }

    public CouldNotReadException(String message) {
        super(message);
    }

    public CouldNotReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public CouldNotReadException(Throwable cause) {
        super(cause);
    }

    protected CouldNotReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
