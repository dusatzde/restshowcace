package cz.filmy.exception;

/**
 * Created by Zdenek on 06-Dec-16.
 */
public class BadRequestException extends ApiException {

    private int code;

    public BadRequestException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
