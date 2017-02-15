package cz.filmy.exception;

/**
 * Created by Zdenek on 06-Dec-16.
 */
public class NotFoundException extends ApiException {

    private int code;

    public NotFoundException (int code, String msg) {
        super(404, msg);
        this.code = code;
    }
}