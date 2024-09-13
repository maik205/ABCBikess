/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcbikes.models;

import abcbikes.exceptions.ItemExistsException;
import abcbikes.exceptions.NotFoundException;
import abcbikes.exceptions.UnqueriableCollectionException;
import abcbikes.interfaces.Queriable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author ASUS
 * @param <T> The type of the collection's objects
 *            This class represents a collection of items that are unique in
 *            value.
 */
public class UniqueMap<K, T> extends HashMap<K, T> {

    public UniqueMap(HashMap<K, T> map) throws ItemExistsException {
        for (K key : map.keySet()) {
            this.put(key, map.get(key));
        }
    }

    public UniqueMap() {
    }

    @Override
    public T put(K key, T value) {
        return null;
    }

    public Map<K, T> queryCollection(UniqueMap<K, T> collection) throws UnqueriableCollectionException {
        // TODO
        return null;
    }

    public void setCollectionSet(Map<K, T> collectionSet) {
        this.clear();
        this.putAll(collectionSet);
    }
}
