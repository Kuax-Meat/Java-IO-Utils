package org.kuax.lib.str;

import java.util.*;

public class StrUtils {
    public static List<String> getIteratorFromStr(String inputStr, char iterLetter) {
        char[] inputChars = inputStr.toCharArray();
        List lst = new ArrayList<String>();
        StringBuilder buf = new StringBuilder();
        int offset = 0;

        while (offset < inputChars.length) {
            if (inputChars[offset] == iterLetter) {
                String apdStr = buf.toString();
                buf.setLength(0);
                lst.add(apdStr);
            } else {
                buf.append(inputChars[offset]);
            }
            offset++;
        }

        /* Get last attribute */
        lst.add(buf.toString());

        return lst;
    }
}
