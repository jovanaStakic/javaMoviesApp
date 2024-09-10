package rs.ac.bg.fon.JavaMoviesApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Jovana Stakic
 */
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class DatabaseException extends RuntimeException{

    public DatabaseException(String message) {
        super(message);
    }

}
