package com.iweb.test;

/**
 * @Author: ChengHao Wu
 * @Date: 2023/3/27 14:36
 */
public class Test {
    public static void main(String[] args) {
        FakeMap<String, String> fm = new FakeHashMap<>();
        fm.put("ikun","zhangsan");
        fm.put("ikun","lisi");
        fm.put("boy","wangwu");
        System.out.println(fm.get("ikun"));
        System.out.println(fm.get("boy"));
    }
}
