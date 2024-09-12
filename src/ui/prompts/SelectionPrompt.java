package ui.prompts;

import java.util.HashMap;

public class SelectionPrompt<T> extends Prompt<T> {
    public final HashMap<String, T> selectionValues;

    private int currentSelection = 0;

    public SelectionPrompt(HashMap<String, T> selectionValues) throws Exception {
        this.selectionValues = selectionValues;
        if (selectionValues.isEmpty()) throw new Exception("Selections can not be empty");
    }

    @Override
    public String render() {
        return "";

    }
}
