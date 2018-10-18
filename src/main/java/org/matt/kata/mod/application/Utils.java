package org.matt.kata.mod.application;

public class Utils {

    private Utils() {
        throw new UnsupportedOperationException();
    }

    private static final char NEW_LINE_CHAR = '\n';

    public static String removeEndingNewLineIfNeeded(String coordinatesline) {
        String s = coordinatesline;
        if (coordinatesline.charAt(coordinatesline.length() - 1) == NEW_LINE_CHAR) {
            s = coordinatesline.substring(0, coordinatesline.length() - 1);
        }
        return s;
    }
}
