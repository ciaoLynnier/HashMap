package com.iweb.test;

import java.util.*;

/**
 * @Author: ChengHao Wu
 * @Date: 2023/3/27 14:11
 */
public class FakeHashMap<K, V> implements FakeMap<K, V> {

    /**
     * 定义一个数组，数组的下标和hashcode值对应，用来存放链表的地址
     */
    LinkedList<Entry<K, V>>[] mapArr = new LinkedList[2000];


    /**
     * 不需要遍历数组，大大减少了代码量，直接存入hashcode的值
     * 用来记录被使用的hashcode，方便后续其他方法的操作
     */
    List<Integer> hashcodeList=new ArrayList<>();

    @Override
    public void put(K key, V value) {
        //根据key计算出key对应的hashcode值
        int hashcode = hashcode(key);
        //hashcode值对应的是数组的下标，应该先判断下标对应的链表是否存在,不存在就先创建
        if (null == mapArr[hashcode]) {
            //创建一个链表，并且将我们的key和value封装成键值对对象Entry并存入链表
            Entry<K, V> entry = new Entry(key,value);
            //链表的内存地址存入数组对应的下标处
            mapArr[hashcode] = new LinkedList<>();
            mapArr[hashcode].add(entry);
            hashcodeList.add(hashcode);
        } else {
            //链表存在说明之前已经有键值对存入，需要我们进行判断
            //需要遍历这个链表：1、如果找到key相同的，则更新链表替换 2、如果没有找到，直接新建对象存入
            boolean found = false;
            loop:
            for (Entry<K, V> entry : mapArr[hashcode]
            ) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    found = true;
                    //若找到则退出循环
                    break loop;
                }
            }
            if (!found) {
                mapArr[hashcode].add(new Entry<K, V>(key, value));
            }
        }
    }

    @Override
    public V get(K key) {
        int hashcode = hashcode(key);
        //如果发现没存过，直接返回空
        if (null == mapArr[hashcode]) {
            return null;
        } else {
            //如果遍历能查找到key，则根据key取出对应的下标的值，返回value
            //如果遍历不能找到，则返回null
            for (Entry<K, V> entry : mapArr[hashcode]
            ) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 删除传入的key值所对应的键值对对象
     *
     * @param key 传入的key
     */
    @Override
    public void remove(K key) {

    }

    /**
     * 清除 HashMap 中的所有关联或者映射
     */
    @Override
    public void clear() {

    }

    /**
     * 判断是否存在key值所对应的映射，返回一个布尔值
     *
     * @param key 传入一个key的值
     * @return 判断是否存在key值所对应的映射，返回一个布尔值
     */
    @Override
    public boolean containsKey(K key) {
        return false;
    }

    /**
     * 获取HashMap的键的集合，以Set<K>保存
     *
     * @return 返回key的集合
     */
    @Override
    public Set<K> keySet() {
        return null;
    }

    /**
     * 得到 HashMap 中各个键值对映射关系的集合
     *
     * @return 返回一个映射关系的集合
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    /**
     * 将指定所有的键值对插入到 HashMap 中
     *
     * @param fakeMap 包含插入到 HashMap 的映射关系
     */
    @Override
    public void putAll(FakeMap<K, V> fakeMap) {

    }

    /**
     * 得到 HashMap 键值对的数量
     *
     * @return 一个int型整数
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * 获取HashMap中value的集合
     *
     * @return 返回value集合
     */
    @Override
    public Collection<V> values() {
        return null;
    }
}
