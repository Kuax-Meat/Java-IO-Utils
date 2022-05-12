package org.kuax.lib.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class JsonUtils {

    public static String makeJsonStrFromMap(Map inputMap) {
        return new Gson().toJson(inputMap, HashMap.class);
    }

    public static String makeJsonStrFromList(List inputList) {
        return new Gson().toJson(inputList, ArrayList.class);
    }

    public static Map<String, Object> makeMapFromJson(String inputJson) throws JsonProcessingException {
        return new ObjectMapper().readValue(inputJson, Map.class);
    }
}
