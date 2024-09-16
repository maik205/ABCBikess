package ui;

import ui.routes.Route;

public class Router {
    private Route currentRoute;
    private InputBuffer input;
    private static String motd;

    Router(InputBuffer input) {
        this.input = input;
    }

    public String renderRoute() {
        StringBuilder result = new StringBuilder();
        result.append(currentRoute.routeDescriptor.toString());
        if (motd != null)
            result.append(motd);
        result.append("-----------\n");

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
