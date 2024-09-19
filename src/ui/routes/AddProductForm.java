package ui.routes;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.exceptions.InvalidItemException;
import abcbikes.services.DataServiceProvider;
import abcbikes.utilities.DataUtils;
import ui.Router;
import utils.RouteDescriptor;

public class AddProductForm extends ProductForm {

    public AddProductForm(Router router) {
        super(router);
    }

    @Override
    protected String provideUID() {
        return DataUtils.getUID(DataServiceProvider.productDataService, "P");
    }

    @Override
    public void submitForm() {
        try {
            if (this.isValid())
                DataServiceProvider.productDataService.addItem(this.parseForm());
            else
                return;
            Router.setMotd("Product added successfully.");
            this.router.navigate(new RecursiveForm(
                    new RouteDescriptor("Continue?", "Would you like to add another product?"),
                    router,
                    this));
        } catch (InvalidFormatException e) {
            Router.setMotd("Invalid format. Please try again.");
        } catch (InvalidItemException e) {
            Router.setMotd(e.getMessage());
        }

    }

}
