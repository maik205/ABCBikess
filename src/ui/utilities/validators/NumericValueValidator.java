package ui.utilities.validators;

import ui.base.FormField;
import ui.utilities.FieldValidator;

public class NumericValueValidator extends FieldValidator{
    private final int minValue;
    private final int maxValue;

    public NumericValueValidator(FormField field, int minValue, int maxValue) {
        super(field);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public NumericValueValidator(FormField field, int minValue) {
        super(field);
        this.minValue = minValue;
        this.maxValue = Integer.MIN_VALUE;
    }

    @Override
    public boolean validatorFunction() {
        try {
            int value = Integer.parseInt(field.getValue());
            if (value < minValue) {
                return false;
            }
            if (maxValue != 0 && value > maxValue) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
        
    }

    @Override
    public String getErrorMessage() {
        throw new UnsupportedOperationException("Unimplemented method 'getErrorMessage'");
    }
    
}
