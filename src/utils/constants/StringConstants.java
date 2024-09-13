package utils.constants;
import java.util.HashMap;
import java.util.Map;
import utils.RouteDescriptor;

public final class StringConstants {
    public final static Map<Short, String> MAIN_MENU = new HashMap<>();

    public final static Map<Short, RouteDescriptor> ROUTE_DESCRIPTOR = new HashMap<>();
    static {
        MAIN_MENU.put((short) 0, "Add a product");
        MAIN_MENU.put((short) 1, "Search a product by name");
        MAIN_MENU.put((short) 2, "Update a product");
        MAIN_MENU.put((short) 3, "Delete a product");
        MAIN_MENU.put((short) 4, "Save to file");
        MAIN_MENU.put((short) 5, "Load product list from file");

        ROUTE_DESCRIPTOR.put((short) 0, new RouteDescriptor("Main Menu", "Press W or S to navigate the options and Enter to select an option"));
        ROUTE_DESCRIPTOR.put((short) 1, new RouteDescriptor("Add a product", "Add a product to the product list"));
        ROUTE_DESCRIPTOR.put((short) 2, new RouteDescriptor("Search a product by name", "Search a product by name"));
        ROUTE_DESCRIPTOR.put((short) 3, new RouteDescriptor("Update a product", "Update a product in the product list"));
        ROUTE_DESCRIPTOR.put((short) 4, new RouteDescriptor("Delete a product", "Delete a product from the product list"));
        ROUTE_DESCRIPTOR.put((short) 5, new RouteDescriptor("Save to file", "Save the product list to a file"));
        ROUTE_DESCRIPTOR.put((short) 6, new RouteDescriptor("Load product list from file", "Load the product list from a file"));
    }
}

