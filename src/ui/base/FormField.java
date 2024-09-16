package ui.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ui.exceptions.InvalidColorException;
import ui.utilities.Colorizer;
import ui.utilities.FieldValidator;
import ui.utilities.StringUtils;
import utils.Utils;

public class FormField {
    private String label;
    private String value;
    private boolean isEditing = false;
    private boolean isSelecting = false;
    private final List<FieldValidator> validators = new ArrayList<>();

    public FormField(String label, String value) {
        this.label = label;
        this.value = value;
    }

    private void setValidators(FieldValidator... validators) {
        this.validators.addAll(Arrays.asList(validators));
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

    public boolean getEditing() {
        return this.isEditing;
    }

    public boolean getSelecting() {
        return this.isSelecting;
    }

    @Override
    public String toString() {
        try {
            StringBuilder result = new StringBuilder();
            String labelColor = isSelecting ? "black" : "white";
            String labelBackground = isSelecting ? (isEditing ? "yellow" : "white") : "black";
            result.append(Colorizer.colorize(this.label, labelColor, labelBackground));
            result.append(
                    StringUtils.renderValueString(this));
            return result.toString();
        } catch (InvalidColorException e) {
            return "Bro you messed up the colors";
        }
    }

}
