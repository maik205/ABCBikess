package utils;

import ui.utilities.Logger;
import utils.constants.StringConstants;

public class Utils {
    public static void clearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); // Check the current operating system

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch (Exception e) {
            Logger.log(e.getMessage());
            Logger.log("Error clearing the console.");
        }
    }

    public static String getLabelPadding(String label) {
        return getLabelPadding(label, StringConstants.FORM_FIELD_PADDING);
    }

    public static String getLabelPadding(String label, int padding) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < padding - label.length(); i++) {
            res.append(" ");
        }
        return res.toString();

    }

}
