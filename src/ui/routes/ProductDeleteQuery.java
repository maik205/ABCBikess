package ui.routes;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.services.DataServiceProvider;
import ui.Router;
import ui.components.forms.ProductQueryActionForm;
import utils.RouteDescriptor;
import utils.constants.StringConstants;

public class ProductDeleteQuery extends ProductQueryActionForm {

    public ProductDeleteQuery(Router router, Route prevRoute) {
        super(StringConstants.ROUTE_DESCRIPTOR.get((short) 4), router, prevRoute);
    }

    @Override
    public void submitForm() {
        try {
            DataServiceProvider.productDataService.remove(parseForm().getId());
            router.navigate(new RecursiveForm(new RouteDescriptor(
                    "Removed item", "Do you want to remove more items?."), router, prevRoute));
        } catch (InvalidFormatException e) {
            Router.setMotd("Product doesn't exist.");
        }
    }

}
