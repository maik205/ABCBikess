package abcbikes.services;

import java.io.IOException;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.exceptions.InvalidItemException;
import ui.Router;

/**
 * DataServiceProvider
 */
public final class DataServiceProvider {
    public static final CategoryDataService categoryDataService = new CategoryDataService();
    public static final BrandDataService brandDataService = new BrandDataService();
    public static final ProductDataService productDataService = new ProductDataService(brandDataService,
            categoryDataService);
    static {
        try {
            categoryDataService.loadFromFile();
            brandDataService.loadFromFile();
            productDataService.loadFromFile();
        } catch (InvalidFormatException e) {
            Router.setMotd("Invalid data found, please input a new file. " + e.getMessage() + "\n");
        } catch (InvalidItemException e) {
            e.printStackTrace();
            Router.setMotd("Invalid item found in collection, please input a new file.\n" + e.getMessage() + "\n");
        } catch (IOException e) {
            Router.setMotd("Can not read data from disk." + e.getMessage() + "\n");

        }
    }
}