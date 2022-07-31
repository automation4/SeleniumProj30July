package com.rahulshetty.tests.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DataFactory {
    private static Supplier<Map<String,String>> CI = ()-> {
        Map<String,String> ci = new HashMap<>();
        ci.put("firstName","Raj");
        ci.put("lasttName","pan");
        ci.put("phone","9838393");
        ci.put("email","rajpan@gmail.com");
        return ci;
    };
    private static Supplier<Map<String,String>> MI = ()-> {
        Map<String,String> ci = new HashMap<>();
        ci.put("address","C-37");
        ci.put("city","delhi");
        ci.put("State_Province","delhi");
        ci.put("Postal_Code","110099");
        ci.put("Country","INDIA");
        return ci;
    };

    private static Supplier<Map<String,String>> FD = ()-> {
        Map<String, String> map = new HashMap<>();
        map.put("trip_type", "oneway");
        map.put("passengers", "2");
        map.put("departing_from", "London");
        map.put("on_month", "March");
        map.put("on_day", "15");
        map.put("arriving", "Paris");
        map.put("returning_to_month", "May");
        map.put("returning_to_day", "15");
        return map;
    };
    private static Supplier<Map<String,String>> UI = ()-> {
        Map<String,String> ci = new HashMap<>();
        ci.put("userName","Himanshu44");
        ci.put("password","password44");
        ci.put("Confirm_password","password44");
        return ci;
    };

    private static Supplier<Map<String,String>> prefrences = ()-> {
        Map<String, String> map = new HashMap<>();
        map.put("serviceclasss","First");
        map.put("Airline","Blue Skies Airlines");
        return map;
    };

    private static Supplier<Map<String,String>> BA = ()->{
        Map<String, String> map = new HashMap<>();
        map.put("streetAddress1","Street address234");
        map.put("streetAddress2","Blue Skies address");
        map.put("city","Gurgram");
        map.put("state","Gurgram");
        map.put("postal","11993");
        return map;
    };

    private static Map<String,Supplier<Map<String,String>>> MAP = new HashMap<>();

    static {
     MAP.put("CI",CI);
     MAP.put("MI",MI);
     MAP.put("UI",UI);
     MAP.put("FD",FD);
     MAP.put("prefrences",prefrences);
     MAP.put("BA",BA);
    }

    public static Map<String,String> getInfo(String infotype){
        return MAP.get(infotype).get();
    }
}
