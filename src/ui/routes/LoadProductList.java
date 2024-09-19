package ui.routes;

import java.io.IOException;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.exceptions.InvalidItemException;
import abcbikes.interfaces.Queriable;
import abcbikes.models.Product;
import abcbikes.services.DataServiceProvider;
import ui.Router;
import ui.components.forms.Form;
import ui.components.forms.FormField;
import utils.RouteDescriptor;
import utils.constants.StringConstants;

public class LoadProductList extends Search {

    public LoadProductList(Router router, Route prevRoute) {
        super(StringConstants.ROUTE_DESCRIPTOR.get((short) 6), router, prevRoute);
    }

    @Override
    public void submitForm() {
        DataServiceProvider.productDataService.clear();
        try {
            DataServiceProvider.productDataService.loadFromFile(this.fields.get(1).getValue());
            Router.setMotd("Successfully loaded file.");
            this.dataList.clear();
            this.dataList.addAll(DataServiceProvider.productDataService.queryMap(fields.get(0).getValue()).values());
            this.dataList.sort((a, b) -> {
                if (a.getListPrice() == b.getListPrice()){
                    return a.getName().compareTo(b.getName());
                }
                return Long.compare(b.getListPrice(), a.getListPrice());
            });
        } catch (InvalidItemException e) {
            Router.setMotd("Duplicate or invalid items found.");
        } catch (InvalidFormatException e) {
            Router.setMotd("File isn't in the valid format.");
        } catch (IOException e) {
            Router.setMotd("Unable to open file for reading.");
        }
    }

    @Override
    public Product parseForm() throws InvalidFormatException {
        throw new UnsupportedOperationException("Method not supported.");
    }

    @Override
    public void initializeForm() {
        super.initializeForm();
        this.setAcceptMessage("Load");
        this.setCancelMessage("Back");
        this.fields.add(new FormField("Path", "Product.txt"));
    }

}
