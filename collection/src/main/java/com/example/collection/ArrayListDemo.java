package com.example.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        String str = "str";
        String str1 = "str1";
        String str2 = "str2";
        String str3 = "str3";
        String strbak = "str";

        List<String> list = new ArrayList<>(8);
        list.add(str);
        list.add(str1);
        list.add(str2);
        list.add(str3);


        /**
         * contains 方法调用indexOf 方法来判断集合中是否有这个对象
         * 使用equals 比较， 如果传入为空也可以查找列表中是否有null元素
         */
        System.out.println(list.contains(str));
        System.out.println(list.contains(strbak));
        System.out.println(list.contains(null));

        /**
         *  indexOf 方法 返回元素第一个出现的下标位置
         *  lastIndexOf 方法 返回元素最后一个出现的下标位置
         *  这两个方法都使用 for 循环加Object.equals来实现
         */
        System.out.println(list.indexOf(str1));
        System.out.println(list.lastIndexOf(str3));

//        List<String> cloneList = list.clone();

        Object[] strs = list.toArray();
        for (int i = 0; i < strs.length; i++) {
            System.out.println((String)strs[i]);
        }

        System.out.println("-----");

        // str str1 str2 str3 null
        String[] pars = {"23", "1234", "23", "124", "xxx"};
        String[] ss = list.toArray(pars);
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }

        // xyz
        System.out.println(list.get(0));
    }
}
