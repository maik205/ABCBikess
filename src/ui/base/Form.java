package ui.base;

import java.util.ArrayList;
import java.util.List;

import ui.InputBuffer;
import ui.Router;
import ui.routes.Route;
import utils.RouteDescriptor;

public abstract class Form<T> extends Route {
    protected final List<FormField> fields = new ArrayList<>();
    private boolean isEditing = false;
    private int currentSelectedFieldIndex = 0;

    public Form(RouteDescriptor routeDescriptor, Router router, Route prevRoute) {
        super(routeDescriptor, router);
        initializeForm();
    }

    @Override
    public void update(Character keyDown) {
        int keyDownInt = (int) keyDown;
        InputBuffer input = router.getInput();
        if (keyDownInt == 13) {
            isEditing = !isEditing;
            if (isEditing == true)
                input.setBuffer(fields.get(currentSelectedFieldIndex).getValue());
        }
        if (isEditing == false) {
            if (Character.toLowerCase(keyDown) == 'w') {
                currentSelectedFieldIndex--;
                if (currentSelectedFieldIndex == -1) {
                    currentSelectedFieldIndex = fields.size() - 1;
                }
            } else if (Character.toLowerCase(keyDown) == 's') {
                currentSelectedFieldIndex++;
                if (currentSelectedFieldIndex == fields.size()) {
                    currentSelectedFieldIndex = 0;
                }
            }
        } else {
            fields.get(currentSelectedFieldIndex).setValue(input.getBuffer());
        }
    }

    /**
     * Render the form
     * 
     * @return the form as a string
     */
    public String renderForm() {
        StringBuilder sb = new StringBuilder();
        fields.forEach(field -> {
            field.setEditing(isEditing && fields.indexOf(field) == currentSelectedFieldIndex);
            field.setSelecting(fields.indexOf(field) == currentSelectedFieldIndex);
            sb.append(field.toString()).append('\n');
        });
        return sb.toString();
    }

    /**
     * Initialize and create the form fields
     */
    public abstract void initializeForm();

    /**
     * Submit the form and returns the appropriate data
     * 
     * @return the data from the form
     */
    public abstract T submitForm();
}
