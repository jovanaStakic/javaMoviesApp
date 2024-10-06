package rs.ac.bg.fon.JavaMoviesApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Jovana Stakic
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthenticationException extends RuntimeException{

    public AuthenticationException(String message) {
        super(message);
    }
    
}
