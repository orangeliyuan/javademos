package com.example.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo1 {


    /**
     * 版本号
     */
    private static final long serialVersionUID = 8683452581122892189L;
    /**
     * 默认初始化大小
     */
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    transient Object[] elementData;
    private int size;


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        init(list);

        List<String> remo = new ArrayList<>();
        remo.add("afds");

//        list.removeAll(remo);

        list.retainAll(remo);
    }

    private static void init(List<String> list) {
        String s1 = "afds";
        String s2 = "fsdafas";
        String s3 = "dfasd;";
        String s4 = "jpi;k";
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
    }
}
