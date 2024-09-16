package ui.utilities.validators;

import ui.base.FormField;
import ui.utilities.FieldValidator;

public class FieldLengthValidator extends FieldValidator {
    private int minLength;
    private int maxLength;

    FieldLengthValidator(FormField field, int minLength, int maxLength) {
        super(field);
        this.minLength = minLength;

    }

    FieldLengthValidator(FormField field, int minLength) {
        super(field);

        this.minLength = minLength;
    }

    @Override
    public boolean validatorFunction() {
        if (maxLength == 0) {
            return field.getValue().length() >= minLength;
        }
        return field.getValue().length() >= minLength && field.getValue().length() <= maxLength;
    }

    @Override
    public String getErrorMessage() {
        if (maxLength == 0) {
            return field.getLabel() + " must be at least " + minLength + " characters long";
        }
        return field.getLabel() + " must be between " + minLength + " and " + maxLength + " characters long";
    }

}
