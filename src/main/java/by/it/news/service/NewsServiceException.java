package by.it.news.service;

import java.io.Serializable;

public class NewsServiceException extends Exception implements Serializable {

    private static final long serialVersionUID = 5218489609615028040L;

    public NewsServiceException() {
        super();
    }

    public NewsServiceException(String message) {
        super(message);
    }

    public NewsServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsServiceException(Throwable cause) {
        super(cause);
    }
}
