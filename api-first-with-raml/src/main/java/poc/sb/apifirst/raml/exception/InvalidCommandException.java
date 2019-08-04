package poc.sb.apifirst.raml.exception;


import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(String s) {
        super(s);
    }

    public InvalidCommandException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
