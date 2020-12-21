package by.it.news.service.validation;

import by.it.news.service.NewsServiceException;

import java.io.Serializable;

public class NewsValidatorException extends NewsServiceException implements Serializable {

    private static final long serialVersionUID = -5875246973163285637L;

    public NewsValidatorException() {
        super();
    }

    public NewsValidatorException(String message) {
        super(message);
    }

    public NewsValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsValidatorException(Throwable cause) {
        super(cause);
    }
}
