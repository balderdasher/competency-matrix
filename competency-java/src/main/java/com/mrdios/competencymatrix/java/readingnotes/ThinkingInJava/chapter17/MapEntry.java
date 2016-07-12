package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter17;

import java.util.Map;

/**
 * Created by balderdasher on 2016/7/12.
 */
public class MapEntry<K,V> implements Map.Entry<K,V>{
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = v;
        value = v;
        return result;
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode())^
                (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SlowMap.MapEntry)){
            return false;
        }
        SlowMap.MapEntry me = (SlowMap.MapEntry) obj;
        return (key == null?me.getKey() == null:key.equals(me.getKey()))
                && (value == null?me.getValue() == null:value.equals(me.getValue()));
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
