package ui.routes;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.models.Product;
import abcbikes.services.DataService;
import abcbikes.services.DataServiceProvider;
import ui.Router;
import utils.RouteDescriptor;

public class UpdateProductForm extends ProductForm {

    private Product product;

    public UpdateProductForm(Router router, Route prevRoute, Product product) {
        super(router, prevRoute);
        this.product = product;
        this.setProduct(product);

    }

    @Override
    protected String provideUID() {
        return this.product.getId();

    }

    @Override
    public void submitForm() {
        try {
            DataServiceProvider.productDataService.put(this.provideUID(),
                    this.parseForm());
        } catch (InvalidFormatException e) {
            Router.setMotd(e.getMessage());
        }
        Router.setMotd("Product updated succesfully.");
        this.router.navigate(new RecursiveForm(
                new RouteDescriptor(this.routeDescriptor.getRouteName(), "Would you like to update another product?"),
                router, prevRoute));
    }

}
