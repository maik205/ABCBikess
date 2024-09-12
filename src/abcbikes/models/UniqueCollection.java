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

import java.util.HashSet;

/**
 *
 * @author ASUS
 * @param <T> The type of the collection's objects
 * This class represents a collection of items that are unique in value.
 */
public class UniqueCollection<T> {
    private final HashSet<T> collectionSet;

    public UniqueCollection(HashSet<T> collectionSet) {
        this.collectionSet = collectionSet;
    }

    public UniqueCollection() {
        this.collectionSet = new HashSet<T>();
    }
    
    public void add(T item) throws ItemExistsException {
        
    }

    public void remove(T item) throws NotFoundException {

    }

    public HashSet<T> queryCollection(UniqueCollection<T> collection) throws UnqueriableCollectionException {


    }

    public HashSet<T> getCollectionSet() {
        return collectionSet;
    }

    public void setCollectionSet(HashSet<T> collectionSet){
        this.collectionSet.clear();
        this.collectionSet.addAll(collectionSet);
    }
}
