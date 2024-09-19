package ui.components.forms;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.models.Product;
import abcbikes.services.DataServiceProvider;
import ui.Router;
import ui.routes.Route;
import ui.routes.Search;
import ui.utilities.validators.LinkValidator;
import utils.RouteDescriptor;

public abstract class ProductQueryActionForm extends Search {

    public ProductQueryActionForm(RouteDescriptor rd, Router router, Route prevRoute) {
        super(
                rd, router, prevRoute);

    }

    @Override
    public abstract void submitForm();

    @Override
    public Product parseForm() throws InvalidFormatException {
        try {
            Product prod = DataServiceProvider.productDataService.get(this.fields.get(1).getValue());
            if (prod == null)
                throw new InvalidFormatException();
            return prod;
        } catch (Exception e) {
            throw new InvalidFormatException("Product doesn't exist.");
        }
    }

    @Override
    public void initializeForm() {
        super.initializeForm();
        this.setAcceptMessage("Continue");
        this.setCancelMessage("Return");
        this.fields.add(
                new FormField("ID", ""));
        this.fields.get(1).setValidators(
                new LinkValidator<>(fields.get(1), DataServiceProvider.productDataService));
    }

}