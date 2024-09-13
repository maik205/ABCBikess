package ui.base;

import java.util.ArrayList;
import java.util.List;

import ui.Router;
import ui.routes.Route;
import utils.RouteDescriptor;

public abstract class Form<T> extends Route {
    protected final List<FormField> fields = new ArrayList<>();
    private boolean isEditing = false;
    private int currentSelectedField = 0;

    public Form(RouteDescriptor routeDescriptor, Router router, Route prevRoute) {
        super(routeDescriptor, router);
        initializeForm();
    }

    @Override
    public void update(Character keyDown) {
        if (isEditing == true) {
            router.getInput().addBuffer(keyDown);

        } else {
            if (Character.toLowerCase(keyDown) == 'w') {
                currentSelectedField--;
                if (currentSelectedField == -1) {
                    currentSelectedField = fields.size() - 1;
                }
            } else if (Character.toLowerCase(keyDown) == 's') {
                currentSelectedField++;
                if (currentSelectedField == fields.size()) {
                    currentSelectedField = 0;
                }
            } else if (Character.toLowerCase(keyDown) == '\n') {
                isEditing = true;
            }
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
            field.setEditing(isEditing);
            field.setSelecting(fields.indexOf(field) == currentSelectedField);
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
