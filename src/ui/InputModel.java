package ui;

import utils.Observable;

public class InputModel extends Observable<Character> {
    private StringBuilder buffer = new StringBuilder();

    public void addBuffer(Character c) {
        if (c == '\b'){
            this.buffer.deleteCharAt(this.buffer.length() - 1);
            return;
        }
        this.buffer.append(c);
    }

    public void clearBuffer() {
        this.buffer.delete(0, this.buffer.length());
    }
}
