package abcbikes.controller;

import abcbikes.models.UniqueCollection;
import abcbikes.views.CollectionView;

public class CollectionController<T> {
    private UniqueCollection<T> collection;
    private CollectionView<T> collectionView;
}
