package org.example.maps;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExamples {

    /*
        // Elements get sorted based on the natural ordering or total ordering
        SortedSet methods()
        1. K firstKey()       equivalent to first() in SortedSet
        2. K lastKey()        equivalent to last() in SortedSet

        - Default mapping is natural ordering of the keys
        - Total ordering can be specified by the customized comparator passed to constructor

        * TreeMap implementation used balanced tree, which delivers excellent performance
        * Searching in HashMap can be faster than TreeMap as, searching in Hashing algorithm is easier
          compared to searching in balanced tree
     */
    public TreeMapExamples() {

        // Natural ordering happens in ascending order
        // for descending order we need to pass Comparator class to override compare() method of Comparator
        NavigableMap<Integer, String> treeMap = new TreeMap<>((a, b) -> b-a);
        treeMap.put(1, "Niraj");
        treeMap.put(6, "Tonu");
        treeMap.put(2, "Monu");
        treeMap.put(3, "Sonu");

        Set<Map.Entry<Integer, String>> treeMaps =  treeMap.entrySet();
        for (Map.Entry<Integer, String> item : treeMaps) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }
}
