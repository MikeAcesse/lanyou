package com.json;

import bean.Diaosi;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class jsonObjectSample {
    public static void main(String[] args) {
       // jsonSampleObject();
       // createJsonByMap();
        createJsonByBean();
    }



    private static void jsonSampleObject() {
        JSONObject wangxiaoer= new JSONObject();
        Object nullObj=null;
        try {
            wangxiaoer.put("name","wangxiaoer");
            wangxiaoer.put("age","25.2");
            wangxiaoer.put("birthday","1990-01-01");
            wangxiaoer.put("major",new String[]{"理发","挖掘机"});
            wangxiaoer.put("school","蓝翔");
            wangxiaoer.put("has_girlfriend",nullObj);
            wangxiaoer.put("car",nullObj);
            wangxiaoer.put("comment","这是一个注释");
            System.out.println(wangxiaoer.toString());

        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    //    {
//        "name": "王小二",
//            "age": 25.2,
//            "birthday": "1990-01-01",
//            "school": "蓝翔",
//            "major": [
//        "理发",
//                "挖掘机"
//  ],
//        "has_girlfriend": false,
//            "car": null,
//            "house": null,
//            "comment": "这是一个注释"
//
//    }

    private static void createJsonByMap(){
        Map<String,Object> wangxiaoer= new HashMap<String,Object>();
        Object nullObj=null;
        wangxiaoer.put("name","wangxiaoer");
        wangxiaoer.put("age","25.2");
        wangxiaoer.put("birthday","1990-01-01");
        wangxiaoer.put("major",new String[]{"理发","挖掘机"});
        wangxiaoer.put("school","蓝翔");
        wangxiaoer.put("has_girlfriend",nullObj);
        wangxiaoer.put("car",nullObj);
        wangxiaoer.put("comment","这是一个注释");
        System.out.println(new JSONObject(wangxiaoer).toString());
    }

    private static void createJsonByBean(){
        Diaosi wangxiaoer =new Diaosi();
        wangxiaoer.setName("wangxiaoer");
        wangxiaoer.setAge(25.2);
        wangxiaoer.setBirthday("1990-11-11");
        wangxiaoer.setSchool("蓝翔");
        wangxiaoer.setMajor(new String[]{"理发，挖掘机"});
        wangxiaoer.setHas_girlfriend(false);
        wangxiaoer.setCar(false);
        wangxiaoer.setComment("This is only a comment");
        JSONObject jsonObject= new JSONObject(wangxiaoer);
        System.out.println(jsonObject.toString());

    }
}
