package unit6.utilities;

public class FormatUtils {
    public static String padRight(String str, int length) {
        return String.format("%1$-" + length + "s", str);
    }

    public static String padString(String prefix, String postfix) {
        return padString(prefix, postfix, 60);
    }

    public static String padString(String prefix, String postfix, int totalLength) {
        int paddingLength = totalLength - prefix.length() - postfix.length() + 1;
        if (paddingLength < 0) {
            postfix = postfix.substring(0, Math.max(postfix.length() + paddingLength, 0));
            paddingLength = 0;
        }
        return prefix + String.format("%1$" + paddingLength + "s", "") + postfix;
    }

    public static String centerString(String middle) {
        return centerString("|", middle, "|", 60);
    }

    public static String centerString(String prefix, String middle, String postfix, int totalLength) {
        int middleLength = totalLength - prefix.length() - postfix.length();
        if (middleLength < 0) {
            middle = middle.substring(0, Math.max(middle.length() + middleLength, 0));
            middleLength = middle.length();
        }

        int paddingTotal = middleLength - middle.length();
        int paddingSide = paddingTotal / 2;
        String padding = String.format("%1$" + paddingSide + "s", "");

        return prefix + padding + middle + padding + (paddingTotal % 2 != 0 ? " " : "") + postfix;
    }

    public static String hr() {
        return hr(60, "-", null);
    }

    public static String hr(String centeredString) {
        return hr(60, "-", centeredString);
    }

    public static String hr(int length) {
        return hr(length, "-", null);
    }

    public static String hr(String c, int length) {
        return hr(length, c, null);
    }

    public static String hr(String c, String centeredString) {
        return hr(60, c, centeredString);
    }

    public static String hr(int length, String c, String centeredString) {
        if (centeredString == null || centeredString.isEmpty()) {
            return String.format("%0" + length + "d", 0).replace("0", c);
        } else {
            // Using "-" as a prefix and postfix with the total length
            String prefix = String.format("%0" + (length / 2 - centeredString.length() / 2) + "d", 0).replace("0", c);
            String postfix = prefix;

            // Adjust for odd lengths
            if ((centeredString.length() % 2 != 0) != (length % 2 == 0)) {
                postfix += c;
            }

            return prefix + centeredString + postfix;
        }
    }
}
