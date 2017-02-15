package cz.filmy.exception;

/**
 * Created by Zdenek on 06-Dec-16.
 */
public class ApiException extends Exception {

    private int code;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
