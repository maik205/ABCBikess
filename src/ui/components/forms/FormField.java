package ui.components.forms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ui.exceptions.InvalidColorException;
import ui.utilities.Colorizer;
import ui.utilities.FieldValidator;
import ui.utilities.StringUtils;

public class FormField {
    private String label;
    private String value;
    private boolean isEditing = false;
    private boolean isSelecting = false;
    private final List<FieldValidator> validators = new ArrayList<>();

    public FormField(String label, String value, FieldValidator... validators) {
        this.label = label;
        this.value = value;
        this.setValidators(validators);
    }

    public void setValidators(FieldValidator... validators) {
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

    public boolean isValid() {
        if (this.value.isEmpty())
            return false;
        for (FieldValidator fv : validators) {
            if (!fv.validatorFunction())
                return false;
        }
        return true;
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
            for (FieldValidator validator : validators) {
                if (!validator.validatorFunction()) {
                    result.append('\n' + Colorizer.colorize(validator.getErrorMessage(), "red"));
                }
            }
            return result.toString();
        } catch (InvalidColorException e) {
            return "Bro you messed up the colors";
        }
    }

}
