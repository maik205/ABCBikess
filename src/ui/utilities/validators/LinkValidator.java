package ui.utilities.validators;

import abcbikes.interfaces.Queriable;
import abcbikes.services.DataService;
import ui.components.forms.FormField;
import ui.utilities.FieldValidator;

public class LinkValidator<T extends Queriable> extends FieldValidator {
    private DataService<T> linkData;

    public LinkValidator(FormField field, DataService<T> linkData) {
        super(field);
        this.linkData = linkData;
    }

    @Override
    public boolean validatorFunction() {
        if (field.getValue().isEmpty())
            return true;
        if (linkData.containsKey(field.getValue()))
            return true;
        return false;
    }

    @Override
    public String getErrorMessage() {
        return String.format("%s %s doesn't exist", this.field.getLabel(), this.field.getValue());
    }

}
