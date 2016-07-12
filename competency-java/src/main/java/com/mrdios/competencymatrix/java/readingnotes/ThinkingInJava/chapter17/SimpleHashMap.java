package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter17;

import java.util.*;

/**
 * 根据散列原理实现的简单的散列Map
 *
 * Created by balderdasher on 2016/7/12.
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    // 指定一个质数作为哈希表的长度，用于获得均匀分布
    static final int SIZE = 997;

    // 用于存放值list的数组,即散列表
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        // 计算该值要存放在数组中的哪个位置
        int index = Math.abs(key.hashCode()) % SIZE;
        // 该位置可用则在此位置初始化存储空间
        if (buckets[index] == null){
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        }
        // 待放入的bucket
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        // 构造键值对
        MapEntry<K,V> pair = new MapEntry<>(key,value);

        boolean found = false;
        // 在数组中对应下标的list中查找key，若存在相同的key则替换旧值
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while (it.hasNext()){
            MapEntry<K,V> iPair = it.next();
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair); // 替换旧值
                found = true;
                break;
            }
        }
        // 为查到key则在数组相应位置中的list中放入此键值对
        if (!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        // 先根据key确定在数组中定位查询范围
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null){
            return null;
        }
        // 在确定的查询范围中根据key查询查到则返回值
        for (MapEntry<K,V> iPair:buckets[index]){
            if (iPair.getKey().equals(key)){
                return iPair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K,V>> bucket : buckets){
            if (bucket == null){
                continue;
            }
            for (MapEntry<K,V> mpair : bucket){
                set.add(mpair);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m = new SimpleHashMap<>();
        m.put("a","a");
        m.put("b","b");
        System.out.println(m);
        System.out.println(m.get("a"));
        System.out.println(m.entrySet());
    }
}
