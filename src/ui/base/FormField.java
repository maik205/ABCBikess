package ui.base;

import ui.exceptions.InvalidColorException;
import ui.utilities.Colorizer;
import utils.Utils;

public class FormField {
    private String label;
    private String value;
    private boolean isEditing = false;
    private boolean isSelecting = false;

    public FormField(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setEditing(boolean isEditing) {
        this.isEditing = isEditing;
    }

    public void setSelecting(boolean isSelecting) {
        this.isSelecting = isSelecting;
    }

    @Override
    public String toString() {
        try {
            StringBuilder result = new StringBuilder();
            String labelColor = isEditing ? "black" : "white";
            String labelBackground = isEditing ? "yellow" : "blue";
            String valueColor = isSelecting ? "black" : "white";
            String valueBackground = isSelecting ? "yellow" : "blue";
            result.append(Colorizer.colorize(this.label, labelColor, labelBackground));
            result.append(Utils.getLabelPadding(label));
            result.append(Colorizer.colorize(this.value, valueColor, valueBackground));
            return result.toString();
        } catch (InvalidColorException e) {
            return "An error occurred";
        }
    }

}
