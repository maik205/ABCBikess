package abcbikes.services;

import java.io.IOException;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.exceptions.InvalidItemException;
import abcbikes.models.Category;
import abcbikes.utilities.Constants;

public class CategoryDataService extends DataService<Category> {

    @Override
    protected int getNumFields() {
        return 2;
    }

    @Override
    protected Category parse(String[] objStrings) throws InvalidItemException, InvalidFormatException {
        try {
            return new Category(objStrings[0], objStrings[1]);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidFormatException("Invalid input");
        }
    }

    @Override
    public void loadFromFile() throws InvalidFormatException, InvalidItemException, IOException {
        this.loadFromFile(Constants.CATEGORY_FILE_NAME);
    }

}
