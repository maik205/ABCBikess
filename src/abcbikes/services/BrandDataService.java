package abcbikes.services;

import java.io.IOException;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.exceptions.InvalidItemException;
import abcbikes.models.Brand;
import abcbikes.utilities.Constants;

public class BrandDataService extends DataService<Brand> {

    @Override
    protected int getNumFields() {
        return 3;
    }

    @Override
    protected Brand parse(String[] objStrings) throws InvalidItemException, InvalidFormatException {
        try {
            return new Brand(objStrings[0], objStrings[1], objStrings[2]);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFormatException("Invalid input format.");
        }
    }

    @Override
    public void loadFromFile() throws InvalidFormatException, InvalidItemException, IOException {
        this.loadFromFile(Constants.BRAND_FILE_NAME);
    }



}
