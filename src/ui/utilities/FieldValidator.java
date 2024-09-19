package ui.utilities;

import ui.components.forms.FormField;

public abstract class FieldValidator {
    protected final FormField field;
    protected String errorMessage;

    public abstract boolean validatorFunction();

    public abstract String getErrorMessage();
    
    public FieldValidator(FormField field) {
        this.field = field;
    }

}
