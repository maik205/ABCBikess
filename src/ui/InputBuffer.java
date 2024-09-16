package ui;

import utils.Observable;

public class InputBuffer extends Observable<Character> {
    private StringBuilder buffer = new StringBuilder();

    public void addBuffer(Character c) {
        if (c == '\b') {
            if (this.buffer.length() > 0)
                this.buffer.deleteCharAt(this.buffer.length() - 1);
            return;
        }
        this.buffer.append(c);
    }

    public void setBuffer(String buffer) {
        this.buffer = new StringBuilder(buffer);
    }

    public void clearBuffer() {
        this.buffer.delete(0, this.buffer.length());
    }

    public String getBuffer() {
        return this.buffer.toString();
    }
}
