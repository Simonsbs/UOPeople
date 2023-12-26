package unit6.utilities;

public class FormatUtils {
    public static String padRight(String str, int length) {
        return String.format("%1$-" + length + "s", str);
    }
}
