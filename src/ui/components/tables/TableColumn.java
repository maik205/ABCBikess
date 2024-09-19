package ui.components.tables;

import abcbikes.interfaces.Queriable;
import abcbikes.services.DataService;

public class TableColumn<T extends Queriable> {
    private int maxWidth;
    private int padding;
    private String header;
    // private final DataService<T> collectionData;

    // Working on this. Currently doesn't do anything.
    public String[] renderColumn() {
        return null;
    }

}
