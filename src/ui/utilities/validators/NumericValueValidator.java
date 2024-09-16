package ui.utilities.validators;

import ui.base.FormField;
import ui.utilities.FieldValidator;

public class NumericValueValidator extends FieldValidator {
    private final double minValue;
    private final double maxValue;

    public NumericValueValidator(FormField field, int minValue, int maxValue) {
        this(field, (double) minValue, (double) maxValue);
    }

    public NumericValueValidator(FormField field, double minValue, double maxValue) {
        super(field);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public NumericValueValidator(FormField field, double minValue) {
        super(field);
        this.minValue = minValue;
        this.maxValue = Double.MIN_VALUE;
    }

    public NumericValueValidator(FormField field, int minValue) {
        this(field, (double) minValue);
    }

    @Override
    public boolean validatorFunction() {
        try {
            double value = Double.parseDouble(field.getValue());
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
