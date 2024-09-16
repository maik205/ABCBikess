package ui.utilities.validators;

import ui.base.FormField;
import ui.utilities.FieldValidator;

public class NumericValidator extends FieldValidator {
    public NumericValidator(FormField field) {
        super(field);
    }

    @Override
    public boolean validatorFunction() {
        try {
            Integer.parseInt(field.getValue());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getErrorMessage() {
        return field.getLabel() + " must be a number";
    }
        
}
