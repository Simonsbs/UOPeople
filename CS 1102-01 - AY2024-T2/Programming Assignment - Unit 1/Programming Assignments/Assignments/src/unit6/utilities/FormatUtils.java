// utilities/FormatUtils.java
package unit6.utilities;

/**
 * Utility class for formatting strings
 */
public class FormatUtils {
    private static final int DEF_LENGTH = 60;
    private static final String DEF_HR_CHAR = "-";
    private static final String DEF_END_CHAR = "|";
    private static final String DEF_PAD_CHAR = " ";

    /**
     * Function to pad a string to the left
     * 
     * @param str    the string to pad
     * @param length the length to pad to
     * @return the padded string
     */
    public static String padRight(String str, int length) {
        return String.format("%1$-" + length + "s", str);
    }

    /**
     * Function to pad a string to the right
     * 
     * @param str    the string to pad
     * @param length the length to pad to
     * @return the padded string
     */
    public static String padString(String prefix, String postfix) {
        return padString(prefix, postfix, DEF_LENGTH);
    }

    /**
     * Function to pad a string to the right
     * 
     * @param prefix      the prefix to pad
     * @param postfix     the postfix to pad
     * @param totalLength the length to pad to
     * @return
     */
    public static String padString(String prefix, String postfix, int totalLength) {
        int contentLength = prefix.length() + postfix.length();
        if (contentLength <= totalLength) {
            int paddingLength = totalLength - contentLength;
            return prefix + String.format("%1$" + paddingLength + "s", "") + postfix;
        } else {
            int truncateLength = totalLength - prefix.length();
            postfix = postfix.substring(0, Math.min(postfix.length(), truncateLength));
            return prefix + postfix;
        }
    }

    /**
     * Function to pad a string to the right
     * 
     * @param str    the string to pad
     * @param length the length to pad to
     * @return the padded string
     */
    public static String centerString(String middle) {
        return centerString(DEF_END_CHAR, middle, DEF_END_CHAR, DEF_LENGTH);
    }

    /**
     * Function to pad a string to the right
     * 
     * @param str    the string to pad
     * @param length the length to pad to
     * @return the padded string
     */
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

    /**
     * Function to pad a string to the right
     * 
     * @param str    the string to pad
     * @param length the length to pad to
     * @return the padded string
     */
    public static String hr() {
        return hr(DEF_LENGTH, DEF_HR_CHAR, null);
    }

    /**
     * Function to pad a string to the right
     * 
     * @param centeredString the string to pad
     * @return the padded string
     */
    public static String hr(String centeredString) {
        return hr(DEF_LENGTH, DEF_HR_CHAR, centeredString);
    }

    /**
     * Function to pad a string to the right
     * 
     * @param length the length to pad to
     * @return the padded string
     */
    public static String hr(int length) {
        return hr(length, DEF_HR_CHAR, null);
    }

    /**
     * Function to pad a string to the right
     * 
     * @param length         the length to pad to
     * @param centeredString the string to pad
     * @return the padded string
     */
    public static String hr(String padding, int length) {
        return hr(length, padding, null);
    }

    /**
     * Function to pad a string to the right
     * 
     * @param length         the length to pad to
     * @param centeredString the string to pad
     * @return the padded string
     */
    public static String hr(String padding, String centeredString) {
        return hr(DEF_LENGTH, padding, centeredString);
    }

    /**
     * Function to pad a string to the right
     * 
     * @param length         the length to pad to
     * @param centeredString the string to pad
     * @return the padded string
     */
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
