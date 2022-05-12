package org.kuax.lib.str;

import java.util.*;

public class StrUtils {

    @Deprecated
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

    public static List<String> getSplittedStrFromStr(String inputStr, char delimiter) {
        StringBuffer stringBuffer = new StringBuffer();
        List<String> results = new ArrayList<>();

        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == delimiter) {
                results.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else {
                stringBuffer.append(inputStr.charAt(i));
            }
        }
        results.add(stringBuffer.toString());

        return results;
    }

    public static String[] getKeyValueFromStr(String inputStr, char delimiter) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] results = new String[2];

        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == delimiter) {
                results[0] = stringBuffer.toString();
                stringBuffer = new StringBuffer();
            } else {
                stringBuffer.append(inputStr.charAt(i));
            }
        }
        results[1] = stringBuffer.toString();

        return results;
    }

    public static void main(String[] args) {
        //0001#SYS:086#PROC01:012#PROC02:030#PROC03:024#PROC04:021#PROC05:005
        String sampleStr = "0001#SYS:086#PROC01:012#PROC02:030#PROC03:024#PROC04:021#PROC05:005";
        List<String> parsedStr = StrUtils.getSplittedStrFromStr(sampleStr, '#');

        Map<String, String> parsedMap = new HashMap<>();
        int i = 0;
        for (String x : parsedStr) {
            if (i == 0) {
                parsedMap.put("id",  x);
            } else {
                String[] t = StrUtils.getKeyValueFromStr(x, ':');
                parsedMap.put(t[0], t[1]);
            }
            i++;
        }

        System.out.println("parsedMap : " + parsedMap);
    }
}
