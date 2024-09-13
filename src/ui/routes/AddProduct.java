package ui.routes;

import abcbikes.models.Product;
import abcbikes.models.UniqueMap;
import ui.Router;
import ui.base.Form;
import ui.base.FormField;
import utils.constants.StringConstants;

public class AddProduct extends Form<Product> {

    public AddProduct(Router router) {

        super(StringConstants.ROUTE_DESCRIPTOR.get((short) 1), router);
    }

    @Override
    public void update(Character value) {

    }

    @Override
    public String renderRouteContent() {
        return this.renderForm();
    }

    @Override
    public void initializeForm() {
        this.fields.add(new FormField("Name", ""));
        this.fields.add(new FormField("Name", ""));
        this.fields.add(new FormField("Name", ""));
        this.fields.add(new FormField("Name", ""));
    }

    @Override
    public Product submitForm() {
        return new Product(null, null, null, null, 0, 0);
    }

}
