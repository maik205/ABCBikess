package abcbikes.utilities;

import abcbikes.exceptions.InvalidFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class FSUtils {
    public static String readTextFile(String path) throws FileNotFoundException, IOException {
        return new String(
                Files.readAllBytes(Paths.get(path)));

    }

    public static String[][] splitFields(String str, int noFields) throws InvalidFormatException {
        List<String[]> objects = new ArrayList<>();
        String[] items = str.split(Constants.NEWLINE_TOKEN);

        for (String item : items) {
            String[] object = item.split(Constants.SPLIT_TOKEN);
            for (int i = 0; i < object.length; i++) {
                object[i] = object[i].trim();
            }
            if (object.length != noFields)
                throw new InvalidFormatException("Invalid input file.");
            objects.add(object);
        }

        return objects.toArray(new String[0][0]);
    }
}
