package abcbikes.utilities;

import abcbikes.exceptions.InvalidFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class FSUtils {
    public static String readTextFile(String path) throws FileNotFoundException, IOException {
        return null;
    }

    public static String[][] splitFields(String str, int noFields) throws InvalidFormatException {
        List<String[]> objects = new ArrayList<>();
        String[] tokens = str.split(Constants.SPLIT_TOKEN);

        if (tokens.length % noFields != 0 || tokens.length == 0)
            throw new InvalidFormatException();

        for (int i = 0; i < tokens.length / noFields; i++) {

            String[] object = new String[noFields];

            for (int j = 0; j < noFields; j++) {
                object[j] = tokens[(noFields * i) + j].trim();
            }
            objects.add(object);
        }
        return (String[][]) objects.toArray();
    }
}
