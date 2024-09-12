package ui.utilities;

import ui.exceptions.InvalidColorException;

import java.util.HashMap;

public class Colorizer {
    private final static HashMap<String, String> colorMap = new HashMap<>();
    private final static HashMap<String, String> backgroundMap = new HashMap<>();

    static {
        colorMap.put("black", Constants.ANSI_BLACK);
        colorMap.put("white", Constants.ANSI_WHITE);
        backgroundMap.put("black", Constants.ANSI_BLACK_BACKGROUND);
        backgroundMap.put("white", Constants.ANSI_WHITE_BACKGROUND);
    }

    public static String colorize(String text, String color) throws InvalidColorException {
        if (colorMap.containsKey(color)) {
            return colorMap.get(color) + text + Constants.ANSI_RESET;
        } else throw new InvalidColorException();
    }

    public static String colorize(String text, String color, String background) throws InvalidColorException {
        if (backgroundMap.containsKey(background)) {
            return backgroundMap.get(background) + colorize(text, color);
        } else throw new InvalidColorException();
    }
}
