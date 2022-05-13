package org.kuax.lib.json;

import com.google.gson.*;
import java.util.*;

public class JsonUtils {

    public static String makeJsonStrFromMap(Map inputMap) {
        return new Gson().toJson(inputMap, HashMap.class);
    }

    public static String makeJsonStrFromList(List inputList) {
        return new Gson().toJson(inputList, ArrayList.class);
    }
}
