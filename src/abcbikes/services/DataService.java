package abcbikes.services;

import abcbikes.exceptions.InvalidFormatException;
import abcbikes.exceptions.InvalidItemException;
import abcbikes.exceptions.InvalidLinkException;
import abcbikes.exceptions.DuplicateItemException;
import abcbikes.interfaces.Queriable;

import abcbikes.utilities.FSUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public abstract class DataService<T extends Queriable> extends HashMap<String, T> {

    DataService() {
    }

    protected abstract int getNumFields();

    DataService(Collection<T> data) {
        data.forEach(item -> {
            try {
                addItem(item);
            } catch (InvalidItemException e) {
                System.out.println(e.getMessage());
            }
        });

    }

    public HashMap<String, T> updateCollectionItem(T oldValue, T newValue) {
        this.put(oldValue.getId(), newValue);
        return this;
    }

    public void addItem(T item) throws InvalidItemException, InvalidLinkException {
        if (this.get(item.getId()) != null)
            throw new DuplicateItemException();
        this.put(item.getId(), item);
    }

    public HashMap<String, T> queryMap(String str) {
        HashMap<String, T> workingMap = new HashMap<>();
        this.forEach((key, value) -> {
            if (value.getQueryString().contains(str))
                workingMap.put(key, value);
        });
        return workingMap;
    }

    protected String[][] getItemStrings(String path, int noFields) throws InvalidFormatException, IOException {
        return FSUtils.splitFields(FSUtils.readTextFile(path), noFields);
    }

    protected abstract T parse(String[] objStrings) throws InvalidItemException, InvalidFormatException;

    public void loadFromFile(String path) throws InvalidFormatException, InvalidItemException, IOException {
        String[][] items = getItemStrings(path, getNumFields());
        for (String[] item : items) {
            try {
                this.addItem(parse(item));
            } catch (InvalidItemException e) {
                throw e;
            } catch (InvalidFormatException e) {
                throw e;
            }
        }
    }

    public abstract void loadFromFile() throws InvalidFormatException, InvalidItemException, IOException;
}
