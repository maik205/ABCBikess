package ui.routes;

import abcbikes.exceptions.InvalidFormatException;

import abcbikes.models.Product;

import abcbikes.services.DataService;
import abcbikes.services.DataServiceProvider;

import abcbikes.utilities.Constants;

import ui.Router;
import ui.components.forms.Form;
import ui.components.forms.FormField;

import utils.RouteDescriptor;
import utils.constants.StringConstants;

import java.util.List;
import java.util.ArrayList;

public class Search extends Form<Product> {

    private int currentPage = 0;
    // Currently a stub, will figure out how to improve using generics later.
    private DataService<Product> dataService = DataServiceProvider.productDataService;
    protected List<Product> dataList = new ArrayList<Product>(dataService.values());

    public Search(Router router, Route prevRoute) {
        super(StringConstants.ROUTE_DESCRIPTOR.get((short) 3), router, prevRoute);
        // TODO Auto-generated constructor stub
    }

    public Search(RouteDescriptor rd, Router router, Route prevRoute) {
        super(rd, router, prevRoute);
    }

    public Search(DataService ds, RouteDescriptor rd, Router router, Route prevRoute) {
        super(rd, router, prevRoute);
        this.dataService = ds;
    }

    @Override
    public void update(Character keyDown) {
        super.update(keyDown);
        if (!this.isEditing) {
            int maxPages = dataService.size() / Constants.PAGE_SIZE;
            if (Character.toLowerCase(keyDown) == 'd') {
                if (this.currentPage >= maxPages - 1) {
                    this.currentPage = 0;
                } else
                    currentPage++;
            }
            if (Character.toLowerCase(keyDown) == 'a') {
                if (this.currentPage <= 1) {
                    this.currentPage = maxPages - 1;
                } else
                    currentPage--;
            }
        }
        if (this.isEditing) {
            this.dataList.clear();
            this.dataList.addAll(this.dataService.queryMap(fields.get(0).getValue()).values());
        }
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
        return String.format("%s\n%s",
                this.renderForm(),
                this.renderPaginator());
    }

    private String renderPaginator() {
        StringBuilder sb = new StringBuilder();
        int maxPages = dataList.size() / Constants.PAGE_SIZE;
        if (this.dataService.size() == 0) {
            sb.append("No products currently available, please load a new file.");
            return sb.toString();
        }
        if (dataList.size() == 0) {
            sb.append("Product not found");
            return sb.toString();
        }

        sb.append(renderPage(currentPage));
        sb.append(String.format("-----------\nPage %d of %d | Showing items %d - %d",
                this.currentPage + 1,
                maxPages == 0 ? 1 : maxPages,
                currentPage * Constants.PAGE_SIZE,
                this.currentPage == maxPages ? this.dataList.size() : (currentPage + 1) * Constants.PAGE_SIZE));
        return sb.toString();
    }

    private String renderPage(int page) {
        StringBuilder sb = new StringBuilder();
        for (int i = currentPage * Constants.PAGE_SIZE; i < (currentPage + 1) * Constants.PAGE_SIZE; i++) {
            try {
                sb.append(dataList.get(i).toLinkedString() + "\n");
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return sb.toString();
    }

    @Override
    public Product parseForm() throws InvalidFormatException {
        throw new InvalidFormatException();
    }

}
