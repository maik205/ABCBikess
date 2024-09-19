package ui.utilities;

import java.util.ArrayList;
import java.util.List;

import ui.components.forms.FormField;
import ui.exceptions.InvalidColorException;
import utils.Utils;
import utils.constants.StringConstants;

public class StringUtils {
    public static String renderValueString(FormField formField) {
        StringBuilder sb = new StringBuilder();
        List<String> splitStrings = splitLongString(formField.getValue());

        // System.out.println(splitStrings[0]);
        String valueColor = formField.getEditing() ? "black" : "white";
        String valueBackground = formField.getEditing() ? "white" : "black";

        for (int i = 0; i < splitStrings.size(); i++) {
            sb.append(Utils.getLabelPadding(i == 0 ? formField.getLabel() : ""));
            try {
                sb.append(
                        Colorizer.colorize(formField.getValue().length() == 0 ? "<Empty>" : splitStrings.get(i),
                                valueColor,
                                valueBackground));
            } catch (InvalidColorException e) {
                e.printStackTrace();
            }
            if (i < splitStrings.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static List<String> splitLongString(String str) {
        List<String> splitStrings = new ArrayList<>();
        StringBuilder workingString = new StringBuilder(str);
        while (true) {
            if (workingString.length() > StringConstants.FORM_FIELD_MAX_LENGTH) {
                splitStrings.add(workingString.substring(0, StringConstants.FORM_FIELD_MAX_LENGTH));
                workingString.delete(0, StringConstants.FORM_FIELD_MAX_LENGTH);
            } else {
                splitStrings.add(workingString.toString());
                break;
            }
        }
        return splitStrings;
    }
}
