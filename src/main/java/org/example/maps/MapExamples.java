package org.example.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExamples {

    public MapExamples() {

        Map<String, Integer> maps = new HashMap<>();
        maps.put("Niraj", 205);
        maps.put("Naman", 206);
        maps.put("Suraj", 207);
        maps.put("Kundan", 208);

        System.out.println("Maps : " + maps);
        // Get the values out of Key(Object)
        System.out.println("Naman : " + maps.get("Naman"));
        // Will get null if that key is not present
        System.out.println("Abhilasha : " + maps.get("Abhilasha"));
        // To handle NullPointerException and return some default values
        System.out.println("Naman : " + maps.getOrDefault("Pankaj", 0));

        System.out.println("Check weather Kundan Key is present : " + maps.containsKey("Kundan"));
        System.out.println("Check weather Pankaj Key is present : " + maps.containsKey("Pankaj"));
        System.out.println("Check weather 205 Value is present : " + maps.containsValue(205));


        Collection<Integer> values = maps.values();
        System.out.println("Value : " + values);

        Set<String> keys = maps.keySet();
        System.out.println("Keys : " + keys);

        // --------------- Traversing -----------------
        // To traverse a map, we need to convert map -> collection
        // entrySet() converts map to set, and we can iterate to that Set
        Set<Map.Entry<String, Integer>> entries = maps.entrySet();

        System.out.println("Traversing using Map.Entry<> --------------");
        // entries is iterable
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("Traversing using KeySet --------------------");
        // Other way to traverse a Map
        Set<String> keysOfMap = maps.keySet();
        for (String key : keysOfMap) {
            System.out.println(key + " :- " + maps.get(key));
        }

    }
}
