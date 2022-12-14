package rest.api.delivery.application.exception;

public class EmailAlreadExistException extends RuntimeException {
    public EmailAlreadExistException(String email) {
        super("Email já existe no sistema: " + email);
    }
}
