package ui.prompts;

import ui.interfaces.Renderable;

public abstract class Prompt<T> implements Renderable {

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }
}
