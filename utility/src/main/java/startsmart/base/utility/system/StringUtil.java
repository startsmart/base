package startsmart.base.utility.system;

import startsmart.base.constant.StringConstants;

/**
 * Created by sanjeev on 09/08/17.
 */
public class StringUtil {

    public static String substringBetween(String inputStr, String open,
                                          String close) {
        if ((inputStr == null) || (open == null) || (close == null)) {
           return null;
        }

        int start = inputStr.indexOf(open);

        if (start != -1) {
            int end = inputStr.indexOf(close, start + open.length());
            if (end != -1) {
                return inputStr.substring(start + open.length(), end);
            }
        }
        return null;
    }

    public static String substringBefore(final String inputStr, final String before) {
        if (inputStr == null || inputStr.isEmpty() || before == null || before.isEmpty()) {
            return inputStr;
        }

        int index = inputStr.indexOf(before);
        if (index == -1) {
            return inputStr;
        }
        return inputStr.substring(0, index);
    }

}
