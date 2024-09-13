package abcbikes.views;

import abcbikes.models.UniqueMap;

public class CollectionView<T> {
    String[] headers;

    public CollectionView(String[] headers) {
        this.headers = headers;
    }

    public CollectionView() {
    }

    /**
     * @param collection The collection to be converted into the view.
     * @return
     */
    public String viewCollection(UniqueMap<T> collection) {
        StringBuilder sb = new StringBuilder();
        collection.getCollectionSet().forEach((item) -> {
            //TODO
        });

        return sb.toString();
    }
}
