package ui;

import ui.routes.Route;

public class Router {
    private Route currentRoute;
    private InputModel input;

    Router(InputModel input) {
        this.input = input;
    }

    public String renderRoute() {
        StringBuilder result = new StringBuilder();
        result.append(currentRoute.routeDescriptor.toString());
        result.append("-----------");

        if (currentRoute != null) {
            result.append(currentRoute.renderRouteContent());
        }
        return result.toString();
    }
    public InputModel getInput() {
        return input;
    }
    public void navigate(Route route) {
        this.input.unsubscribe(currentRoute);
        this.input.subscribe(route);
        this.currentRoute = route;
    }
}
