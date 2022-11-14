package siit.exception;

public class ValidationException extends RuntimeException {

    private final String code;

    public ValidationException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
