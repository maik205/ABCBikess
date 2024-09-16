package ui.routes;

import abcbikes.exceptions.InvalidItemException;
import abcbikes.models.Brand;
import abcbikes.models.Product;
import abcbikes.services.DataServiceProvider;
import abcbikes.utilities.DataUtils;

import ui.Router;
import ui.base.Form;
import ui.base.FormField;
import ui.utilities.validators.FieldLengthValidator;
import ui.utilities.validators.LinkValidator;
import ui.utilities.validators.NumericValidator;
import utils.RouteDescriptor;
import utils.constants.StringConstants;

public class AddProductForm extends Form {

    public AddProductForm(Router router) {
        super(StringConstants.ROUTE_DESCRIPTOR.get((short) 1), router, null);
    }

    @Override
    public String renderRouteContent() {
        return this.renderForm();
    }

    @Override
    public void initializeForm() {
        this.fields.clear();
        FormField name = new FormField("Name", "");
        name.setValidators(
                new FieldLengthValidator(name, 5));
        this.fields.add(name);

        FormField brandId = new FormField("Brand ID", "");
        brandId.setValidators(
                new FieldLengthValidator(brandId, 4),
                new LinkValidator<Brand>(brandId, DataServiceProvider.brandDataService));
        this.fields.add(brandId);

        FormField categoryId = new FormField("Category ID", "");
        categoryId.setValidators(
                new FieldLengthValidator(categoryId, 4),
                new LinkValidator<>(categoryId, DataServiceProvider.categoryDataService));
        this.fields.add(categoryId);

        FormField modelYear = new FormField("Model Year", "");
        modelYear.setValidators(
                new NumericValidator(modelYear, new Integer(69)));
        this.fields.add(modelYear);

        FormField listPrice = new FormField("Price", "");
        listPrice.setValidators(
                new NumericValidator(listPrice, new Long(69)));
        this.fields.add(listPrice);

    }

    @Override
    public void submitForm() {
        for (FormField field : fields) {
            if (field.getValue().isEmpty() || !field.isValid())
                return;
        }
        Product product = new Product(
                DataUtils.getUID(DataServiceProvider.productDataService, "P"),
                fields.get(0).getValue(),
                fields.get(1).getValue(),
                fields.get(2).getValue(),
                Integer.parseInt(fields.get(3).getValue()),
                Long.parseLong(fields.get(4).getValue()));
        try {
            DataServiceProvider.productDataService.addItem(product);
        } catch (InvalidItemException e) {
            Router.setMotd("Something went wrong adding the product.");
        }
        this.router.navigate(new RecursiveForm(
                new RouteDescriptor("Continue?", "Would you like to add another product?"),
                router,
                this));
    }

    @Override
    public void cancelForm() {
        router.navigate(new MainMenu(router));
    }

}
