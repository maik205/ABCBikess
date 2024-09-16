package abcbikes.exceptions;

public class InvalidLinkException extends InvalidItemException {
    public InvalidLinkException(String msg) {
        super(msg);
    }

    public InvalidLinkException() {
    }
}
