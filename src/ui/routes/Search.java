package ui.routes;

import abcbikes.services.DataServiceProvider;
import ui.Router;
import ui.base.Form;
import ui.base.FormField;

import utils.constants.StringConstants;

public class Search extends Form {

    public Search(Router router, Route prevRoute) {
        super(StringConstants.ROUTE_DESCRIPTOR.get((short) 3), router, prevRoute);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void initializeForm() {
        this.setCancelMessage("");
        this.setAcceptMessage("Back");

        this.fields.add(new FormField(
                "Query: ", ""));
    }

    @Override
    public void submitForm() {
        router.navigate(prevRoute);
    }

    @Override
    public void cancelForm() {
        router.navigate(prevRoute);
    }

    @Override
    public String renderRouteContent() {
        return this.renderForm() + DataServiceProvider.productDataService.queryMap(fields.get(0).getValue());
    }

}
