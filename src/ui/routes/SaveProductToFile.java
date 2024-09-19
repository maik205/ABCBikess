package ui.routes;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.models.Product;
import abcbikes.services.DataServiceProvider;
import ui.Router;
import ui.components.forms.Form;
import ui.components.forms.FormField;
import utils.constants.StringConstants;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class SaveProductToFile extends Form<Product> {

    public SaveProductToFile(Router router, Route prevRoute) {
        super(StringConstants.ROUTE_DESCRIPTOR.get((short) 5), router, prevRoute);
    }

    @Override
    public void submitForm() {
        try (PrintWriter out = new PrintWriter(this.fields.get(0).getValue());) {
            for (Product prod : DataServiceProvider.productDataService.values()) {
                out.println(prod.toFileString());
            }
            Router.setMotd("Successfully saved products");

        } catch (FileNotFoundException e) {
            File file = new File(this.fields.get(0).getValue());
            try {
                file.createNewFile();
                submitForm();
            } catch (IOException ioe) {
                Router.setMotd(ioe.getMessage());
            }
        }
        router.navigate(prevRoute);
    }

    @Override
    public Product parseForm() throws InvalidFormatException {
        throw new InvalidFormatException();
    }

    @Override
    public void initializeForm() {
        this.fields.add(
                new FormField("Path",
                        "Products.txt"));
    }

    @Override
    public void cancelForm() {
        router.navigate(prevRoute);
    }

    @Override
    public String renderRouteContent() {
        return renderForm();
    }

}
