package ui;

import abcbikes.utilities.Constants;
import ui.exceptions.InvalidColorException;
import ui.routes.Route;
import ui.utilities.Colorizer;
import utils.constants.StringConstants;

/**
 * Router class that manages the current route and renders it
 */
public class Router {
    private Route currentRoute;
    private InputBuffer input;
    private static String motd;

    Router(InputBuffer input) {
        this.input = input;
    }

    /**
     * Renders the current route
     * 
     * @return String representation of the current route
     */
    public String renderRoute() {
        StringBuilder result = new StringBuilder();
        try {
            result.append(Colorizer.colorize(Constants.COMPANY_NAME + '\n', "yellow"));
        } catch (InvalidColorException e) {
            System.out.println("Check the colors");
        }
        result.append(currentRoute.routeDescriptor.toString());
        if (motd != null)
            result.append(motd);
        result.append("\n-----------\n");

        if (currentRoute != null) {
            result.append(currentRoute.renderRouteContent());
        }
        return result.toString();
    }

    public static void setMotd(String str) {
        motd = str;
    }

    public InputBuffer getInput() {
        return input;
    }

    public void navigate(Route route) {
        this.input.unsubscribe(currentRoute);
        this.input.subscribe(route);
        this.currentRoute = route;
    }
}
