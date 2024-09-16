package ui.utilities;

import java.util.HashMap;

import abcbikes.interfaces.Queriable;
import abcbikes.services.DataService;
import ui.base.FormField;

public class FieldSuggestor<T extends Queriable> {
    private DataService<T> dataService;
    private FormField field;

    public FieldSuggestor(
            DataService<T> dataService,
            FormField field

    ) {
        this.dataService = dataService;
        this.field = field;
    }

    public String getSuggestion() {
        HashMap<String, T> queryResult = this.dataService.queryMap(field.getValue());
        if (queryResult.isEmpty())
            return "";
        for (Queriable q : queryResult.values()) {
            if (q.getQueryString().contains(field.getValue())) {
                return q.getId();
            }
        }
        return "";
    }
}
