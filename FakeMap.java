package com.iweb.test;

import java.util.Collection;
import java.util.Set;

/**
 * @Author: ChengHao Wu
 * @Date: 2023/3/27 13:55
 */
public interface FakeMap<K, V> {

    /**
     * 将键值对存入我们自己实现的FakeMap中
     *
     * @param key   传入的key
     * @param value key所对应的值
     */

    void put(K key, V value);

    /**
     * 通过传入key来获取对应的值
     *
     * @param key 传入的key
     * @return 返回key对应的值，没有则返回null
     */
    V get(K key);

    /*
        hashmap所使用的hashcode方法应该来自于key本身提供
        1、我们在模拟hashmap时，需要保证hashcode值的范围，不能超过数组的下表
        2、jdk1.8之后接口内可以写静态方法和default方法
        3、如果两个对象的hashcode相同，对象不一定相同；
            如果对象相同，hashcode一定相同
     */

    /**
     * 自己定义的hashcode方法
     *
     * @param key 需要计算hashcode值的key
     * @return int类型的hashcode值，人为地将值限制在了0-1999
     */
    default int hashcode(K key) {
        return key.toString().hashCode() % 2000;
    }


    /**
     * 删除传入的key值所对应的键值对对象
     *
     * @param key 传入的key
     */
    void remove(K key);

    /**
     * 清除 HashMap 中的所有关联或者映射
     */
    void clear();

    /**
     * 判断是否存在key值所对应的映射，返回一个布尔值
     *
     * @param key 传入一个key的值
     * @return 判断是否存在key值所对应的映射，返回一个布尔值
     */
    boolean containsKey(K key);

    /**
     * 获取HashMap的键的集合，以Set<K>保存
     *
     * @return 返回key的集合
     */
    Set<K> keySet();

    /**
     * 得到 HashMap 中各个键值对映射关系的集合
     *
     * @return 返回一个映射关系的集合
     */
    Set<Entry<K, V>> entrySet();

    /**
     * 将指定所有的键值对插入到 HashMap 中
     *
     * @param fakeMap 包含插入到 HashMap 的映射关系
     */
    void putAll(FakeMap<K, V> fakeMap);

    /**
     * 得到 HashMap 键值对的数量
     *
     * @return 一个int型整数
     */
    int size();

    /**
     * 获取HashMap中value的集合
     *
     * @return 返回value集合
     */
    Collection<V> values();

}
