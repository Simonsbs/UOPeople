package unit6.utilities;

public class FormatUtils {
    private static final int DEF_LENGTH = 60;
    private static final String DEF_HR_CHAR = "-";
    private static final String DEF_END_CHAR = "|";
    private static final String DEF_PAD_CHAR = " ";

    public static String padRight(String str, int length) {
        return String.format("%1$-" + length + "s", str);
    }

    public static String padString(String prefix, String postfix) {
        return padString(prefix, postfix, DEF_LENGTH);
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
        return centerString(DEF_END_CHAR, middle, DEF_END_CHAR, DEF_LENGTH);
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

        return prefix + padding + middle + padding + (paddingTotal % 2 != 0 ? DEF_PAD_CHAR : "") + postfix;
    }

    public static String hr() {
        return hr(DEF_LENGTH, DEF_HR_CHAR, null);
    }

    public static String hr(String centeredString) {
        return hr(DEF_LENGTH, DEF_HR_CHAR, centeredString);
    }

    public static String hr(int length) {
        return hr(length, DEF_HR_CHAR, null);
    }

    public static String hr(String padding, int length) {
        return hr(length, padding, null);
    }

    public static String hr(String padding, String centeredString) {
        return hr(DEF_LENGTH, padding, centeredString);
    }

    public static String hr(int length, String padding, String centeredString) {
        if (centeredString == null || centeredString.isEmpty()) {
            return String.format("%0" + length + "d", 0).replace("0", padding);
        } else {
            int totalPaddingLength = length - centeredString.length();
            int paddingSide = totalPaddingLength / 2;

            String prefix = String.format("%0" + paddingSide + "d", 0).replace("0", padding);
            String postfix = prefix;

            // Adjust for odd lengths
            if (totalPaddingLength % 2 != 0) {
                postfix += padding;
            }

            return prefix + centeredString + postfix;
        }
    }
}
