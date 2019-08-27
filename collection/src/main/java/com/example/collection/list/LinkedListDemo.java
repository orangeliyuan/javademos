package com.example.collection.list;

import java.util.*;

public class LinkedListDemo {

    public static void main(String[] args) {
//        System.out.println(tableSizeFor(16));

        Map<String, String> map = new HashMap<>();
        String re = map.put("k1", "v1");
        System.out.println(re);
//        map.containsKey()
        Set<String> set = new HashSet<>();
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }
}
