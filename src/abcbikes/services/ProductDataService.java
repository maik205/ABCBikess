package abcbikes.services;

import java.io.IOException;
import java.util.Collection;

import abcbikes.exceptions.InvalidLinkException;
import abcbikes.exceptions.InvalidFormatException;
import abcbikes.exceptions.InvalidItemException;
import abcbikes.models.Product;
import abcbikes.utilities.Constants;

public class ProductDataService extends DataService<Product> {
    private final BrandDataService brandDataService;
    private final CategoryDataService categoryDataService;

    public ProductDataService(Collection<Product> data, BrandDataService brandDataService,
            CategoryDataService categoryDataService) throws InvalidItemException {
        super(data);
        this.brandDataService = brandDataService;
        this.categoryDataService = categoryDataService;
    }

    public ProductDataService(BrandDataService brandDataService, CategoryDataService categoryDataService) {
        this.brandDataService = brandDataService;
        this.categoryDataService = categoryDataService;
    }

    @Override
    public void addItem(Product product) throws InvalidItemException, InvalidLinkException {
        if (!this.brandDataService.containsKey(product.getBrandId())) {
            throw new InvalidLinkException(String.format("Brand %s doesn't exist", product.getBrandId()));
        }
        if (!this.categoryDataService.containsKey(product.getCategoryId())) {
            throw new InvalidLinkException(String.format("Category %s doesn't exist", product.getCategoryId()));
        }
        super.addItem(product);
    }

    @Override
    protected int getNumFields() {
        return 6;
    }

    @Override
    protected Product parse(String[] objStrings) throws InvalidItemException, InvalidFormatException {
        try {
            return new Product(objStrings[0], objStrings[1], objStrings[2], objStrings[3],
                    Integer.parseInt(objStrings[4]), Long.parseLong(objStrings[5]));
        } catch (NumberFormatException e) {
            throw new InvalidItemException("Invalid numeric fields." + String.join("x", objStrings));
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFormatException("Invalid input");
        }
    }

    @Override
    public void loadFromFile() throws InvalidFormatException, InvalidItemException, IOException {
        this.loadFromFile(Constants.PRODUCT_FILE_NAME);
    }

}
