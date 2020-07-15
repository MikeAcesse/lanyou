package com.json;

import java.util.HashMap;
import java.util.Map;

public class TestCollection {
    public static void main(String[] args) {
         Map map = new HashMap<String,String>();
         map.put("name","fanzhikang");
         map.put("major",null);
         System.out.println(map.toString());

    }
}
