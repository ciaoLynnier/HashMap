package com.iweb.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ChengHao Wu
 * @Date: 2023/3/27 14:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry<K, V> {
    private K key;
    private V value;
}
