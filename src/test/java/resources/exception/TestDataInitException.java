package resources.exception;

public class TestDataInitException extends RuntimeException {
    public TestDataInitException() {
    }

    public TestDataInitException(String message) {
        super(message);
    }

    public TestDataInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestDataInitException(Throwable cause) {
        super(cause);
    }

    public TestDataInitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
