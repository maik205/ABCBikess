package ui.routes;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.models.Brand;
import abcbikes.models.Product;
import abcbikes.services.DataServiceProvider;

import ui.Router;
import ui.components.forms.Form;
import ui.components.forms.FormField;
import ui.utilities.validators.FieldLengthValidator;
import ui.utilities.validators.LinkValidator;
import ui.utilities.validators.NumericValidator;
import ui.utilities.validators.NumericValueValidator;
import utils.constants.StringConstants;

import java.time.Year;

public abstract class ProductForm extends Form<Product> {

    public ProductForm(Router router) {
        super(StringConstants.ROUTE_DESCRIPTOR.get((short) 1), router, null);
    }

    public ProductForm(Router router, Route prevRoute) {
        super(StringConstants.ROUTE_DESCRIPTOR.get((short) 1), router, prevRoute);
    }

    @Override
    public String renderRouteContent() {
        return this.renderForm();
    }

    @Override
    public void initializeForm() {
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
                new NumericValidator(modelYear, new Integer(69)),
                new NumericValueValidator(modelYear, 0, Year.now().getValue()));
        this.fields.add(modelYear);

        FormField listPrice = new FormField("Price", "");
        listPrice.setValidators(
                new NumericValidator(listPrice, new Long(69)),
                new NumericValueValidator(listPrice, 0));
        this.fields.add(listPrice);

    }

    @Override
    public Product parseForm() throws InvalidFormatException {
        for (FormField field : fields) {
            if (field.getValue().isEmpty() || !field.isValid())
                throw new InvalidFormatException();
        }
        return new Product(
                this.provideUID(),
                fields.get(0).getValue(),
                fields.get(1).getValue(),
                fields.get(2).getValue(),
                Integer.parseInt(fields.get(3).getValue()),
                Long.parseLong(fields.get(4).getValue()));
    }

    @Override
    public void cancelForm() {
        router.navigate(new MainMenu(router));
    }

    protected void setProduct(Product productData) {
        this.fields.get(0).setValue(productData.getName());
        this.fields.get(1).setValue(productData.getBrandId());
        this.fields.get(2).setValue(productData.getCategoryId());
        this.fields.get(3).setValue(Short.toString(productData.getModelYear()));
        this.fields.get(4).setValue(Long.toString(productData.getListPrice()));
    }

    protected abstract String provideUID();

    public abstract void submitForm();

}
