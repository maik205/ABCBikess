package ui.routes;

import java.util.Map;

import ui.Router;
import utils.constants.StringConstants;

public class MainMenu extends Route {
    public MainMenu(Router router) {
        super(StringConstants.ROUTE_DESCRIPTOR.get((short) 0), router);
    }

    private short selectedOption = 0;
    private Map<Short, String> mainMenuOptions = StringConstants.MAIN_MENU;

    @Override
    public void update(Character value) {
        // Handle up and down actions
        if (Character.toLowerCase(value) == 'w') {
            selectedOption--;
            if (selectedOption == -1) {
                selectedOption = 5;
            }
        } else if (Character.toLowerCase(value) == 's') {
            selectedOption++;
            if (selectedOption == 6) {
                selectedOption = 0;
            }
        }

        // Handle enter action
        if (value.equals('\n')) {
            switch (selectedOption) {
                case 0:
                    router.navigate(null);
                    System.out.println("Add a product");
                    break;
                case 1:
                    System.out.println("Search a product by name");
                    break;
                case 2:
                    System.out.println("Update a product");
                    break;
                case 3:
                    System.out.println("Delete a product");
                    break;
                case 4:
                    System.out.println("Save to file");
                    break;
                case 5:
                    System.out.println("Load product list from file");
                    break;
            }
        }
    }

    @Override
    public String renderRouteContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < 6; i++) {
            if (i == selectedOption) {
                sb.append("-> ");
            } else {
                sb.append("   ");
            }
            sb.append("Option ").append(i + 1).append(": ");
            sb.append(mainMenuOptions.get((short) i));
            sb.append("\n");
        }
        return sb.toString();
    }

}
