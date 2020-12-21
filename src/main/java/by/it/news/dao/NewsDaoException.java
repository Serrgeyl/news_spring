package by.it.news.dao;

import java.io.Serializable;

public class NewsDaoException extends Exception implements Serializable {

    private static final long serialVersionUID = 499782180222728743L;

    public NewsDaoException() {
        super();
    }

    public NewsDaoException(String message) {
        super(message);
    }

    public NewsDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsDaoException(Throwable cause) {
        super(cause);
    }
}
