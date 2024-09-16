package abcbikes.utilities;

import java.util.Random;

import abcbikes.services.DataService;

public final class DataUtils {

    public static String getUID(DataService ds) {
        Random rand = new Random();
        Integer randNum = rand.nextInt(Integer.MAX_VALUE);
        if (ds.containsKey(randNum.toString()))
            return getUID(ds);
        return randNum.toString();
    }

    public static String getUID(DataService ds, String prefix) {
        String uid = prefix + getUID(ds);
        if (ds.containsKey(uid))
            return getUID(ds, prefix);
        return uid;
    }
}
