package org.kuax;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.kuax.lib.str.StrUtils;
import org.kuax.sample.vo.SampleVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOUtilsApp {

    public static void testStr() {
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
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(parsedMap);
        System.out.println("json = " + json);
        JsonObject header = new JsonObject();
        JsonElement jsonElement = gson.toJsonTree(parsedMap);

        Map<String, String> body = new HashMap<>();
        body.put("data", "심심이");
        header.add("head", jsonElement);
        header.add("body", gson.toJsonTree(body));
        String headerjson = gson.toJson(header);
        System.out.println("headerjson = \n" + headerjson);
    }

    public static void convertJson() {
        String sampleJson = "{\n" +
                "  \"code\": 200,\n" +
                "  \"msg\": \"You're OK to Joining\",\n" +
                "  \"person\": {\n" +
                "    \"name\": \"John Doe\",\n" +
                "    \"phone\": \"010-4510-7830\"\n" +
                "  }\n" +
                "}";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        SampleVo sampleVo = gson.fromJson(sampleJson, SampleVo.class);

        System.out.println("sampleVo = " + sampleVo);
    }
    public static void main(String[] args) {
        testStr();
        convertJson();
    }
}
