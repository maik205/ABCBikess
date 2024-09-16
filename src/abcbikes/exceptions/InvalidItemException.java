package abcbikes.exceptions;

public class InvalidItemException extends Exception {
    InvalidItemException() {

    }

    public InvalidItemException(String msg) {
        super(msg);
    }
}
